package patterns.behavioral.observer2.observerEvents;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/*
This is a different implementation of the Observer pattern using "Events"
 */

/**
 * Event encapsulates the idea of something happening
 * @param <TArgs> - the actual data of the event
 */
class Event <TArgs> {
    private int count = 0;
    // a map of subscribers
    private Map<Integer, Consumer<TArgs>>
            handlers = new HashMap<>();

    public Subscription addHandler( Consumer<TArgs> handler ) {
        int i = count;
        handlers.put( count++, handler );
        return new Subscription( this, i );
    }

    public void fire( TArgs args ) {
        for ( Consumer<TArgs> handler : handlers.values() )
            handler.accept( args );
    }

    //a Memento that encapsulates a subscription to an event
    //AutoCloseable so we can put it into a TRY WITH resources
    public class Subscription implements AutoCloseable {
        private Event<TArgs> event;
        //in index into the handlers map of an Event
        private int id;

        public Subscription( Event<TArgs> event, int id ) {
            this.event = event;
            this.id = id;
        }

        @Override
        public void close() /*throws Exception*/ {
            event.handlers.remove( id );
        }
    }
}

//notification object that gets fired from an event
class PropertyChangedEventArgs {
    public Object source;
    public String propertyName;

    public PropertyChangedEventArgs( Object source, String propertyName ) {
        this.source = source;
        this.propertyName = propertyName;
    }
}

class Person {

    //Person can "fire" propertyChanged Event(s)
    public Event<PropertyChangedEventArgs>
            propertyChanged = new Event<>();

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge( int age ) {
        if ( this.age == age ) return;

        boolean oldCanVote = getCanVote();

        this.age = age;
        propertyChanged.fire( new PropertyChangedEventArgs(
                this, "age"
        ) );

        if ( oldCanVote != getCanVote() ) {
            propertyChanged.fire( new PropertyChangedEventArgs(
                    this, "canVote"
            ) );
        }
    }

    public boolean getCanVote() {
        return age >= 18;
    }
}

class HandmadeEventsDemo {
    public static void main( String[] args ) {
        Person person = new Person();
        Event<PropertyChangedEventArgs>.Subscription sub =
                person.propertyChanged.addHandler( x -> {
                    System.out.println( "Person's " + x.propertyName + " has changed" );
                } );
        person.setAge( 17 );
        person.setAge( 18 );
        sub.close();
        person.setAge( 19 );
    }
}
