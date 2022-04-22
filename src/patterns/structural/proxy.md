# Pattern
* in plain words - 
    * Using the proxy pattern, a class represents the functionality of another class
* you need to provide a placeholder or surrogate to another object
* the proxy acts on behalf of the (proxied) object
* examples:
    * protection proxy - control access to original object's operations
    * remote proxy - provides a local representation of a remote object
    * virtual proxy - delays construction of original object until absolutely necessary
* client is unaware that it is using a proxy.
    * proxy performs its work transparently
 
    
## Implementation Steps (Static proxy)
* proxy must implement the same interface as the real object
* we can either create actual object later when required or ask for one in the constructor
* in method implementations of proxy we implement proxy's functionality before delegating to the real object
* your application will decide how to provide a client with the proxies instance
    * we can provide a factory or compose client code with proxies instance
* what we are implementing above is a "static" proxy. Java also provides "dynamic proxies"

## Implement a Dynamic Proxy
* this is provided by Java out of the box
* start by implementing java.lang.reflect.InvocationHandler
    * invocation handler implements invoke method which is called to handle every method invocation on the proxy
    * you need to take action as per the method invoked:
        * cache the method instances on image interface so that we can compare them inside the invoke method
    * our invocation handler will accept the same argument in constructor as needed by the constructor of the real object
* actual proxy instance is created using ```java.lang.reflect.Proxy``` by client
    
## Implementation Considerations
* how a proxy gets hold of the real object depends on what purpose proxy serves
    * for creation "on demand" types of proxies; actual object is created only when proxy can't handle client request
    * authentication proxies use pre-built objects, so they are provided with real object during construction of proxy
* the proxy itself can maintain/cache some state on behalf of the real object in "creation on demand" use cases
* pay attention to performance cost of proxies as well as synchronization issues added by the proxy itself
    
## Design Considerations
* proxies typically do not need to know about the actual concrete implementation of real objects
* with Java you can use dynamic proxy allowing you to create proxies for any object at runtime
* proxies are great for implementing security or as stand-ins for real objects which may be a costly to create and you
want to defer loading them until absolutely needed
* proxies also make working with remote services/APIs easy by representing them as regular objects and possibly handling
network communications behind the scenes

## Example
* these are everywhere in the wild
* Hibernate uses a proxy to load collections of value types
* Spring Framework
    * uses both JDK Dynamic and CGLIB
    
## Compare   
|                                           Proxy                                            |                                                      Decorator                                                      |
|:------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------------------:|
|            depending on type of proxy, it doesn't need real object all the time            |                                    needs to have a real object in order to work                                     |
| purpose of proxy is to provide features like access control, lazy loading, auditing etc... | decorator is meant to add functionality to existing functionality provided by object and is used by client directly |

## Pitfalls
* Java's dynamic proxy only works if your class implements one or more interfaces
* if you need proxies for handling multiple responsibilities (like auditing,authentication,etc..) then it is better to
have a single proxy that handles all these requirements, due to the way some proxies create real object on their own, it 
becomes quite difficult to manage them
    * you want a single proxy for one single real object instance
* static proxies look similar to other patterns like decorator and adapter patterns
    * it can be quite confusing to figure it out from code alone for someone not familiar with all these patterns


## Summary                                                                                            
* you want a stand-in or placeholder object, or you want to **control access** to a real object's method(s), then you 
can use a proxy pattern
* proxies implement the same interface as the real object. It delegates actual functionality to the real object.
* proxies are either given the real object or they create one when needed. Some proxies talk to remote service behind
the scenes
* main usage of proxies is for:
    * Protection Proxy - control access to original object's operations
    * Remote Proxy - provides a local representation of a remote object
    * Virtual Proxy - delays construction of original object until absolutely necessary
* in java we can have Dynamic proxies. These are created on the fly at runtime