# Chain of Responsibility
* you need to avoid coupling code which sends a request to code which handles that request
    * typically the code which want some request handled, calls the exact method on an exact object to process it,
    causing tight coupling.
    * Chain of responsibility solves this problem by giving more then one object a chance to process the request
* you create objects which are chained together via one object which knows the next object in the chain
* you give a request to the first object in the chain, if it can't handle it, it passes the request the next object
in the chain 


## Implementation Steps
* start by defining handler interface/abstract class
    * handler must define a method to accept incoming request
    * handler can define a method to access successor in the chain
        * if it's an abstract class, then it could maintain the successor
* next, implement handler in one or more concrete handlers
    * concrete handler should check if it can handle the request
    * if not, it should pass the request to the next handler
* next, create your chain of objects, typically in the real world, this job will be done by some framework or 
initialization code written by you
* client only needs to know about the first object in the chain, it'll pass on request to this object

## Implementation Considerations
* prefer defining the handler as an interface as it allows you to implement chain of responsibility without worrying
about Java's single inheritance rule
* handlers can allow the request to propagate even if they handle the request
    * Servlet filter chains allow request to flow to next filter even if the perform some action of the request
* the chain of handlers can be configured using XML,JSON,etc.. so that you can add and remove handlers without
modifying code
    
## Design Considerations
* you might be able to use existing connections or chains in your objects.
    * ie. if you are using the composite pattern you already have a chain which can be used to implement this behavior
    

## Example
* Servlet filters
    * each filter gets a chance to handle the request and then pass it down the chain


## Compare
Chain of Responsibility | Command
:---:|:---:   
if handler can't handle the request it will pass it on to next handler | there is no passing on of the request, command handles it itself
there is no guarantee that the request will be handled at all | it is assured that the request will be handled and command will be executed
we don't track which handler, handled the request and can't reverse the actions of handlers | commands are trackable, and are stored in execution order and are reversible


## Pitfalls
* no guarantee that a request will be handled, request could go thru whole chain without being handled
* chain could be misconfigured, will need to test/code review to make sure this doesn't happen

## Summary
* you want to decouple sender of request from object which handles the request
* you want this decoupling because you want to give multiple objects a chance to handle the request and you don't know
all the objects before hand
* a handler checks if it can handle the request, if it CAN'T then it will pass the request to the next object in the chain
* you can pass the request down the chain even if a handler, handles the request. It is up to you to decide this