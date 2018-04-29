# Bridge Pattern
* When we use normal inheritance, our implementations and abstractions are generally coupled to each other
* Using bridge pattern, we can decouple them so they can both change without affecting each other
* This is achieved by creating two separate inheritance hierarchies, one for implementation and another for abstraction
* Composition is used to bridge these two hierarchies

## Implementing Bridge
* start by defining the abstraction needed by the client
    * determine common base operations and define them in the abstraction
    * optionally - define a refined abstraction and provide more specialized operations
        * this abstraction does not have to be an abstract class or interface
        * this "abstraction" class simply contains methods that "abstract" out (or hide) the complexity from the client
    * define the *implementor* next. Implementor methods do **not** have to match with abstractor
        * however, abstraction can carry out its work by using implementor methods
    * then we write one or more concrete implementors providing implementation
* Abstractions are created by composing them with an instance of concrete implementor which is used by methods in
the abstraction

## Implementation Considerations
* In the case where you have a single implementation, then you can skip creating the abstract implementor
* The abstraction can decide on its own which concrete implementor to use in its constructor
    * OR we can delegate that decision to a third class
        * in this approach, the abstraction remains unaware of concrete implementors and provides greater de-coupling

## Design Considerations
* Bridge provides great extensibility by allowing us to change abstraction and implementor independently.
    * you can build and package them separately to modularize the overall system (eg. in separate jar files)
* By using Abstract Factory pattern ro create abstraction objects with correct implementation you can de-couple
concrete implementors from abstraction

## Examples of Bridge Pattern
* JDBC API - ```java.sql.DriverManager``` with the ```java.sql.Driver``` interface form a bridge pattern
* Collections.newSetFromMap() - returns a Set backed by the given Map object    

## Comparison with Adapter Pattern
Bridge | Adapter
:---:|:---:
Intent is to allow abstraction and implementation to vary independently | Adapter is meant to make unrelated classes work together
Bridge has to be designed up front, so that we can have varying abstractions & implementations | adapter is typically used when new code needs to work with a legacy system

## Pitfalls
* It is fairly complex to understand and implement
* you need to have a well thought out and fairly comprehensive design in front of you before you can decide on the bridge pattern
* needs to be designed up front. Adding bridge to existing code base is difficult

## Summary
* Use bridge pattern when you want your abstractions and implementations to be decoupled
* Bridge pattern defines separate inheritance hierarchies for abstractions and implementations and "bridges" these 
together using composition
* implementations do not HAVE to define methods that match up with methods in the abstraction
    * it is common to have "primitive" methods (methods that do small amount of work) in the implementor
    * abstraction uses these methods to provide its functionality
    