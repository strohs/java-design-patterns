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
* allows adding extra behavior to entire hierarchies of classes
* need to define a new operation on an entire class hierarchy
    * e.g. make a document model printable to HTML/Markdown
* do not want to keep modifying every class in the hierarchy
* need access to the non-common aspects of classes in the hierarchy
* create an external component to handle rendering
    * but avoid type checks

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
* dom4j library org.dom4j.Visitor
* java.nio.file.FileVisitor which is implemented in SimpleFileVisitor

## Compare
Visitor | Strategy
:---:|:---:   
all visitor subclasses provide possibly different functionalities from each other | each subclass represents a separate algorithm to solve the **same** problem


## Pitfalls
* visitors often need access to the object's state...weakening the encapsulation
* supporting a new class in our visitors requires changes to all visitor implementations
* if the classes (being visited) change, then all visitors have to change as well since they have to work with the 
changed class
* this pattern could be confusing to understand and implement

## Summary
* visitor pattern allows you to add new operations that work on objects, **without modifying the class definitions of those objects**
* visitors define class specific methods which work with an object of that class to provide new functionality
* classes that use this pattern define an *accept* method which gets a reference to a visitor
    * this visitor will have a "visit" method that is tailored to work on the class being visited
    * the class's accept method is called, which in turn kicks off the visitor's visit method
* adding a new functionality means creating a new visitor and implementing new functionality in that class instead of
modifying each class where this functionality is needed
* this pattern is often used where we have an object structure and then another class or visitor itself iterates over
this structure passing our visitor object to each object