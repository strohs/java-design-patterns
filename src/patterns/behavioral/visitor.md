# Visitor
* allows you to define new operations that can be performed on an object without changing the class definition of the object
* it uses an object called the "visitor" that visits all nodes in an object structure
    * each time our visitor visits a particular object from the structure, that object calls a specific method on visitor,
    passing itself as an argument
* each time we need a new operation, we create a subclass of visitor, implement the operation in that class and visit the
object structure
* objects themselves only implement an "accept" visit, where the visitor is passed as an argument
    * objects know about the method in visitor created specifically for it and invoke that method inside the accept method

## Motivation

## Implementation Steps
* we create visitor interface by defining "visit" methods for each concrete class we want to support
* the classes who want functionality provided by visitor define an "accept" method which accepts a visitor.
    * these methods are defined using the visitor interface as a parameter type so that we can pass any class implementing
    the visitor to these methods
* in the accept method implementation, we'll call a method on visitor which is defined specifically for that class
* next we implement the visitor interface in one or more classes
    * each implementation provides a specific functionality for interested classes. If we want another feature we create
    a new implementation of visitor
    


## Implementation Considerations

    
## Design Considerations


## Example

## Compare
Visitor | PATTERN
:---:|:---:   

## Pitfalls


## Summary
