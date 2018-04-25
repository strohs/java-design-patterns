# Adapter (aka Wrapper)
* you have an existing object which provides the functionality you need, but your code can't use this object because
it expects and object with a different interface
* using Adapter, you can make the existing object work with the client by adapting the object to the client's expected
interface
* this pattern is also called wrapper, as it "wraps" the existing object
* two general types of Adapter
    * class adapter (aka two way adapter)
    * Object adapter (preferred way to implement adapter pattern)
    
## Implementation
* An object adapter should take adaptee as an argument in the constructor or as a less preferred solution, you can
instantiate it in the constructor thus tightly coupling with a specific adaptee

## Implementation Considerations
* how much work the adapter does depends upon the differences between the target interface and object being adapted.
    * if method objects are the same or similar, adapter has less work to do
* using *class adapter* "allows" you to override some of the adaptee's behavior. This should be avoided as you end
up with adapter that behaves differently than adaptee
    * fixing defects will not be easy anymore
* using object adapter allows you to potentially change the adaptee object to one of its subclasses (the subclass may
have improvements or fixes). You can easily pass the new subclass into the adapter via the adapter constructor
    * this is only possible with object adapter 

## Design Considerations
* In Java, a class adapter may not be possible if both target and adaptee are concrete classes. In the case, object
adapter is the only solution
* A *class adapter* is called a two-way adapter since it can stand in for both the target interface and for the adaptee.
We can use the adapter object where either the target interface is expected as well as where adaptee object is expected
    * class adapter is not the preferred way to implement the Adapter pattern 
    
## Example of Adapter
* java.io.InputStreamReader and java.io.OutputStreamWriter are examples of object adapters
    * these classes adapt existing InputStream/OutputStream object to Reader/Writer interface
    
## Comparison with Decorator
Adapter | Decorator
:---:|:---:
simply adapts an object to another interface without changing behaviour | enhances object behavior without changing its interface
not easy to use recursive composition, that is an adapter adapting another adapter since adapters change interface | since decorators do not change the interface, we can do recursive composition (decorate a decorator) Since a decorator is indistinguishable from the main object

## Pitfalls
* *class adapters* create an adapter that exposes unrelated methods in parts of your code, polluting it. Avoid class adapters
* It is tempting to do a lot of things in adapter besides simple interface translation, but this can result in an adapter
showing different behavior than the adapted object
    * just do simple interface translation.

## Summary
* a class adapter is one type of Adapter implementation where adapter inherits from class of object which is to be adapted
and implements the interface required by client code. Avoid this type
* a object adapter is the other type of Adapter that uses composition. it'll implement the target interface and use adaptee
object composition to perform translation. This allows us to use subclasses of adaptee in adapter  