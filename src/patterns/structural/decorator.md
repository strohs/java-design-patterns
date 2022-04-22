# Decorator
* you want to enhance behavior of an existing object dynamically (at runtime)
* decorator wraps an object within itself and provides the same interface as the wrapped object
    * the client of the original object does not need to change
* decorator provides alternative to subclassing for extending functionality of existing classes

## Implementation Steps
* start with your component (to be decorated)
    * component defines interface needed or already used by client
    * concrete component implements the component
    * define your decorator
        * decorator implements the component and also takes a reference to the concrete component
        * decorator methods provide additional behaviour on top of the behaviour already provided by the concrete component
* decorator can be abstract and depend on subclasses to provide functionality

## Implementation Considerations
* since we have decorators and concrete classes extending from a common component, try to avoid keeping a large amount
of state in the base class as decorators may not need it all
* pay attention to equals and hashCode methods of the decorator
    * when using decorators, you have to decide if decorated object is equal to the instance without the decorator
* decorators support recursive composition
    * this is a pattern where lots of small objects are created that add "just a little bit" of functionality
    * code using these objects can be difficult to debug
    
## Design Considerations
* decorators are more flexible and powerful than inheritance
    * inheritance is static be definition but decorators allow you to dynamically compose behaviour using objects at runtime
* decorators should act like additional "skin" over your object
    * they should add helpful, small, behaviour to the objects original behaviour
    * DO NOT change the original meaning of operations in your decorator

## Example of Decorator
* classes in Java I/O package
    * java.io.BufferedOutputStream decorates any java.io.OutputStream by adding buffering functionality

## Compare Decorator and Composite    
Decorator | Composite
:---:|:---:
intent is to "add to" existing behaviour of existing object | composites are meant for object aggregation only
decorator can be thought of as a degenerate composite with only one component | composites support any number of components in aggregation

## Pitfalls
* often results in large number of classes being added to the system, where each class adds a small amount of functionality
    * you often end up with lots of objects, one nested inside of the other...
* sometimes, new comers will start using it as a replacement to inheritance in every scenario
    * think of decorators as a **thin skin** over an existing object
    * decorators should only be adding small bits of functionality

## Summary
* use decorator when you want to add a **small bit** of functionality to an existing object
* a decorator has the same interface as the object it decorates (or contains)
* decorators allow you to dynamically construct behaviour by using composition
    * a decorator can wrap another decorator which in turn wraps the original object
* client of the object is unaware of the existence of the decorator