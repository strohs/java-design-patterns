package patterns.creational.objectPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

public class ObjectPool<T extends Poolable> {

    //this is our in memory cache
    private BlockingQueue<T> availablePool;

    /**
     *
     * @param creator - functional interface that creates an object to store in the object pool
     * @param count - how many objects to create when initializing the object pool
     */
    public ObjectPool( Supplier<T> creator, int count ) {
        availablePool = new LinkedBlockingQueue<>();
        for ( int i = 0; i < count; i++ ) {
            availablePool.offer( creator.get() );
        }
    }

    public T get() {
        try {
            //this will wait until some object becomes available to us. In reality you may want to create new objects
            // if none are available, or you may just want to block until one is available
            return availablePool.take();
        } catch ( InterruptedException e ) {
            System.err.println( "take() was interrupted" );
        }
        return null;
    }

    public void release(T obj) {
        obj.reset();
        try {
            availablePool.put( obj );
        } catch ( InterruptedException e ) {
            System.err.println( "put() was interrupted" );
        }
    }
}
