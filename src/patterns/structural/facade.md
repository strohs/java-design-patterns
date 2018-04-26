# Facade
* Facade solves the problem of a client that has to interact with a large number of interfaces and classes in a 
subsystem, causing the client to become tightly coupled to those interfaces and classes
    * if any changes are made to those interfaces and classes, you will have to make sure the client code still works
* Facade provides a simple and unified interface to a subsystem
    * clients now interact with just the facade in order to get the same results
* Facade is **not** just a one to one method forwarding to other classes


## Implementation Steps
* start by creating a class that will serve as the Facade
    * determine the overall "use cases"/tasks that the subsystem is user for
    * write a method that exposes each "use case" or task
    * this method takes care of working with different classes of the subsystem

## Implementation Considerations
* a facade should minimize the complexity of a subsystem and provide a usable interface (for clients)
* You can have an interface or abstract class for facade and client can use different subclasses to talk to different
subsystem implementations
* a facade is not a replacement for regular usage of classes in a subsystem. Those can still be used outside of the
facade.
    * Your subsystem class implementation should not make any assumptions about the usage of a facade by client code

    
## Design Considerations
* Facade is a great solution to simplify dependencies. It allows you to have weak coupling between subsystems
* If your **only** concern is the coupling of client code to subsystem specific classes and your not concerned about the
simplification provided by a facade, then you can use abstract factory pattern in place of facade
    

## Example of Facade
* ```java.net.URL```
    * openStream() - a method that returns an input stream to the resource pointed at by the URL object
        * java.net.URL takes care of working with multiple classes in java.net package in order to provide the final input stream


## Compare Facade with Adapter
Facade | Adapter
:---:|:---:
Intent is to simplify the usage of a subsystem for client code | adapter is meant to simply adapt an object to a different interface
facade is not restricted by any existing interface. It often defines simple methods which handle complex interactions behind the scenes | adapter is always written to conform to a particular interface expected by client code. It has to implement all the methods from the interface and adapt them using existing objects
  
## Pitfalls
* NOTE: if you need a facade in a **new** design, you should re-examine/redesign your design
* It is often overused/misused and can hide an improperly designed API
    * a common misuse is to use them as "containers of related methods"
    * be on the lookout for such cases during code reviews 

## Summary
* use facade when using our subsystem requires dealing with lots of classes and interfaces and you want to provide a
simple interface for a client, that provides the same functionality
* Facade is not simply method forwarding. 
    * Facade methods encapsulate the subsystem class interactions which otherwise would have been done by client code
* Facades are often added over existing legacy code in order to simplify code usage and reduce coupling of client code
to legacy code
