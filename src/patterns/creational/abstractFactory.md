# Abstract Factory
* abstract factory is used when we have two or more objects which work together, forming a kit or set.
    * there can be multiple sets or kits that can be created by the client code
* we separate client code from concrete objects that form such a set and also from the code which creates these sets

## Implement Abstract Factory
* start by studying the product "sets"
    * create abstract factory as an abstract class or an interface
    * abstract factory defines abstract methods for creating products
    * provide concrete implementation of factory for each set of products
* abstract factory makes use of factory method pattern
    * you can think of abstract factory as an object with multiple factory methods...

## Implementation Considerations
* factories can be implemented as singletons
    * we usually only need one instance of it anyway
    * be sure to know the drawbacks of singletons
* Adding a new product (i.e. a "Network" product) type requires changes to the base factory as well as all implementations of factory
* we provide the client code with concrete factory so that it can create objects

## Design Considerations
* when you want to constrain object creations so that they all work together then abstract factory is a good
design pattern
* abstract factory uses factory method pattern (i.e. createInstance() createStorage() )
* if objects are expensive to create, then you can transparently switch implementations to use prototype design
pattern to create objects

## Examples
* javax.xml.parsers.DocumentBuilderFactory
    * however, this class has a static newInstance() method which returns actual factory object

## Compare and Contrast Abstract Factory with Factory Method
* Abstract Factory
    * hides factories as well as concrete objects used from the client code
    * suitable when multiple objects are designed to work together and client must use products from a single family
    at a time
* Factory Method
    * hides the concrete objects which are used from the client code
    * concerned with one product and its subclasses. Collaboration of the product itself with other objects is irrelevant

## Pitfalls
* a lot more complex to implement than factory method
* adding a new product requires changes to base factory as well as ALL implementations of factory
* difficult to visualize the need at the start of development and usually starts out as a factory method
* abstract factory is very specific to the problem of **product families**

## Summary
* you have multiple sets of objects where objects in one set work together, then you can use abstract factory to
isolate client code from concrete objects and their factories
* abstract factory uses factory method and you can think of them as objects with multiple factory methods
* adding a new product type needs changes to base factory and all its implementations
* concrete factories can be singleton, as we typically need only one instance of them in code
* we provide client code with concrete factory instance. Factories can be changed at runtime