# Object Pool
* if **cost of creating an instance** of a class is high and you need **a large number of objects** of the class
for a **short duration**, then you can use an object pool
* you will either pre-create objects of the class or collect unused instances in an in memory cache.
    * when code needs an object of the class we provide it from the cache
* this is one of the most complicated patterns to implement efficiently (and without defects)

## implementation steps
* start by creating a class for object pool
    * a thread-safe caching of objects should be done in the pool
    * methods to acquire and release objects should be provided and pool should reset cached objects before
    giving them out
* the reusable object must provide methods to reset its state upon "release" by the code
* we have to decide whether to create new pooled objects when pool is empty or to wait until an object becomes
available. Choice is influenced by whether the object is tied to a fixed number of external resources

## Implementation Considerations
* resetting object state should **not** be a costly operation, otherwise you may end up losing your performance savings
* Pre-caching objects - creating X number of objects in advance may be helpful
    * will add to start-up time and memory consumption
* Object pool's synchronization should consider the reset time needed & avoid resetting within a synchronized context

## Design considerations
* object pool can be parameterized to cache and return multiple objects and the acquire method (get()) can provide selection
criteria 
* pooling objects is only beneficial if they involve costly initialization because of initialization of external
resources like a connection or thread.
    * Don't pool objects just to save memory, unless you are running into OUT OF MEMORY errors
* do not pool long lived objects (objects that are held by a client for a long period of time) or only to save 
frequent calls to ```new```. Pooling may actually negatively impact performance

## Examples
* using object pool to save memory allocation and GC cost is *almost* deprecated now. JVMs and hardware are more
efficient and have access to more memory
* however still very common when interacting with external resources like threads, or connections
* ```java.util.concurrent.ThreadPoolExecutor```
    * often used via ExecutorService interface using method like newCachedThreadPool()
* database connection pooling i.e. apache.commons.dbcp.BasicDataSource   

## Pitfalls
* successful implementation depends on correct use by client code. Releasing objects back to the pool is vital for
correct operation
* the reusable object needs to take care of resetting its state in efficient way. Some objects may not be suitable
for pooling due to this requirement
* difficult to use in refactoring of legacy code, as client code and reusable object need to be aware of object pool
* you have to decide what happens when the pool is empty and there is a demand for an object
    * you can either wait for object to be placed in the pool or create a new object
        * both approaches have trade-offs

## Summary
* if **cost of creating an instance** of a class is high and you need **a large number of objects** of the class
for a **short duration**, then you can use an object pool
* typically objects that represent fixed external system resources like threads, connections or other system resources
are good candidates for pooling
* objects to be pooled should provide a method to "reset" their state so they can be reused. This operation should be
efficient as well, otherwise release operations will be costly
* pool must handle synchronization issues efficiently and reset object state before adding them to pool for reuse
* client code has responsibility to return objects back to the pool. Failing to do so will break the system.
* difficult to optimize as pools are sensitive to system load at runtime
* pools are a good choice when pooled objects represent a fixed quantity of externally available resource like a thread
or connection
* you have to make sure to trim object pool back to a reasonable size if you end up creating additional objects for
your pool , if not you could end up with a large number of pooled objects