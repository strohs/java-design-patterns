# Factory Method

## What is factory method?
* you want to move object creation logic into a separate class
* use this pattern when you do not know in advance which class you may need to instantiate beforehand
    * this pattern allows new classes to be added to the system and handles their creation without affecting client code
* subclasses are used to decide which object to instantiate be overriding the factory method

## Implementation Steps
* start by creating a class for our creator
    * creator itself can be concrete if it can provide a default object OR it can be abstract
    * implementations will override the method and return an object
    
## Implementation Considerations
* the creator can be a concrete class and provide a default implementation for the factory method
    * in such cases you'll create some "default" object in the base creator
* you can also use the simple factory way of accepting additional arguments to choose between different object
types. Subclasses can then override factory method to selectively create different objects for some criteria

## Design Considerations
* creator hierarchy in factory method pattern reflects the product hierarchy. We typically end up with a concrete
creator per object type
* *template method* design pattern often makes use of factory methods
* another creational design pattern called *abstract factory* makes use of factory method pattern

## Example
* java.util.Collection (or java.util.AbstractCollection)
    * has an abstract method called Iterator()
* remember the most defining characteristic of factory method pattern is **subclasses providing the actual instance**
    * so static methods returning object instances are technically not GoF factory methods

## Pitfalls
* More complex to implement. More classes involved and need unit testing
* it's not easy to refactor existing code into Factory Method pattern, so you'll have to start with Factory method
pattern from the beginning
* sometimes this pattern forces you to subclass just to create appropriate instance

## Summary
* use factory method when you want to delegate object instantiation to subclasses
    * you'd want to do this when you have "product" inheritance hierarchy and possibility of a future addition to that
    hierarchy
    * adding a new "product" and a new "creator" for that product won't change any existing code