# Flyweight
* suppose your system needs a large number of objects of a particular class and maintaining these instances (in memory) is 
a performance concern
* flyweight allows us to share an object in multiple contexts
    * but instead of sharing the entire object, which may not be feasible, we divide object state into two parts:
        * intrinsic - state that is shared in every context
        * extrinsic - context specific state
    * you create objects with only intrinsic state and share them in multiple contexts
* a client of our object provides the extrinsic state to our object in order to carry out its functionality
* you provide a factory so client can get required flyweight objects based on some key (that identifies the flyweight)


## Implementation Steps
* start by identifying "intrinsic" and "extrinsic" state of our object
    * create an interface for flyweight to provide common methods that accept extrinsic state
    * in implementation of shared flyweight we add intrinsic state and also implement methods
    * in unshared flyweight implementation we simply ignore the extrinsic state argument as we have all state within the
    object
* next we implement the flyweight factory which caches flyweights and also provides a method to get them
* in our client, we either maintain the extrinsic state, or compute it on the fly when using flyweight

## Implementation Considerations
* a factory is necessary with flyweight pattern as client code needs an easy way to get a hold of shared flyweight.
    * also...the number of shared instances can be large so a central place to keep track of all of them is a good
    strategy
* flyweights intrinsic state should be immutable for successful use of the flyweight pattern 
    
## Design Considerations
* usability of flyweight is entirely dependant upon presence of sensible extrinsic state in object which can be moved
out of object without any issue
* some other design patterns like state and strategy can make the best use of flyweight pattern

## Example
* Java uses flyweight pattern for Wrapper classes like java.lang.Integer, Short, Byte, etc...
    * in this case, the ```valueOf``` static method serves as the factory method
* String pool which is maintained by the JVM is also an example of flyweight
    * we can call the ```intern()``` method on a String object to explicitly request the String to be interned
        * this method will return a reference to the already cached object, else it will create a new object
## Compare
Flyweight | Object Pool
:---:|:---:
The state of a flyweight object is divided. Client must provide part of state to it. | a pooled object contains all of its state encapsulated within itself
In typical usage, client will not change intrinsic state of flyweight instance as it is shared | clients can and will change state of pooled objects   

## Pitfalls
* runtime cost may be added for maintaining extrinsic state. Client code has to either maintain it or compute it every
time it needs to use flyweight
* it is often difficult to find perfect candidate objects for flyweight. Graphical applications benefit heavily from this
pattern, however a typical web application may not have a lot of use for it

## Summary
* It is used to minimize memory usage or computational expenses by sharing as much as possible with similar objects
* use flyweight if you need a large number of objects of a class where you can easily separate out state that can be
shared and state that can be externalized
* flyweights store only "intrinsic" state or state that can be shared in any context
* Code using flyweight instance provides the "extrinsic" state when calling methods on flyweight
    * flyweight object then uses this state, along with its inner state to carry out its work
* client code can store extrinsic state per flyweight instance or compute it on the fly