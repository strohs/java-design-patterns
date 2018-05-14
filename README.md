# Java Design Patterns
Gang of Four design patterns implemented in Java, along with notes (implementation details,pitfalls,etc..) 
about each pattern.

## Summaries
### Creational
* deal with creation of objects from classes

#### Builder
* logic related to object construction is removed from client code and abstracted into a separate "builder" class
    * often used when a constructor takes a lot of parameters
    * or when a objects need other objects (or parts) to construct them
* the builder class "builds" the final object, often by calling a "build" or "create" method
    
#### Factory Method
* you want to delegate object instantiation to subclasses
    * subclasses are used to decide which object to instantiate by overriding the "factory method"
* this pattern is often used when you do not know in advance which class you may need to instantiate

#### Abstract Factory
* used when you have **two or more objects that work together**, forming a "kit" or "set"
* abstract factory uses factory method, and you can think of them as objects with multiple factory methods

#### Prototype
* used when you have a complex object that is costly to create
* to create more instances of this complex object you use an existing instance is a "prototype"
* in Java, the ```clone()``` method is used to create the prototype
    * you must decide whether to create a deep copy of a shallow copy

#### Singleton
* a class is instantiated once (and only once)
* the singleton is accessed globally through a single access point (via a method or field)
* it's possible to create "eager" singletons as well as "lazily loaded" singletons
    * eager - "classic" singleton uses "double checked" locking and a volatile field (have to deal with synchronization)
    * lazy - there is also the "holder idiom" (don't have to deal with synchronization issues)
    * eager - can also use "enums" to create singletons, could be a hard-sell due to notions of what a enum should be used for
    
#### Object Pool
* if the cost of creating in instance of a class is high and you need a large number of them for a "short period of time"
then you should consider object pool pattern
* objects in the pool are pre-created and unused instances are collected in a memory cache
* complicated to implement
    * have to decide what to do when pool is empty and there is demand for a object
    * relies on client code returning objects to the pool once client code is finished with the object
    * the pool must handle synchronization issues efficiently as well as reset object state before returning to the pool
    
### Structural
* structural patterns deal with how classes and objects are arranged or composed. Using composition and inheritance 
you can solve some interesting design problems


### Behavioral
* behavioral patterns describe how classes and objects interact and communicate with each other

