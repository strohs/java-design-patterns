# Java Design Patterns
Gang of Four design patterns implemented in Java, along with notes (implementation details,pitfalls,etc..) 
about each pattern.


## Creational
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
    
## Structural
* structural patterns deal with how classes and objects are arranged or composed. Using composition and inheritance 
you can solve some interesting design problems

#### Adapter (Wrapper)
* **a construct which adapts an existing interface X to conform to the required interface Y**
* you have an existing object that provides the functionality you need, but your code can't use this object because it
expects an object with a different interface
* preferred way to implement this is via a "object adapter"
    * it will implement the target interface and use "adaptee" object composition to perform the translation
    * allows you to use subclasses of adaptee in adapter

#### Bridge
* **connecting components together through abstractions**
* prevents a "Cartesian product" complexity explosion
    * e.g. you have a base class ```ThreadScheduler```
        * ThreadScheduler can be Preemptive or cooperative
        * ThreadScheduler can also run on Windows or Linux
        * now you have a 2x2 scenario where you will have to implement 4 classes
            * WindowsPTS, WindowsCTS, LinuxPTS, LinuxCTS
* Bridge Pattern avoids the entity explosion
* Bridge pattern defines separate inheritance hierarchies for abstractions and implementations and "bridges" these 
together using composition

#### Composite
* **treating individual objects (scalar) and aggregate objects (collections) uniformly**
* objects can use other object's fields/methods through inheritance and composition
* composition lets us make compound objects
    * e.g. a mathematical expression composed of simple expressions
    * e.g. a shape group composed of several different shapes
* Composite design pattern is used to treat both single and composite objects uniformly
    * e.g. Foo and List<Foo> have common APIs
    * in the end, a composite pattern implementation will allow you to write algorithms without worrying about 
    whether an object is a scalar or aggregate

#### Decorator
* **adding behavior to a class without altering the class itself**
* you want to augment an object with additional functionality
    * but you don't want to rewrite or alter existing code (Open/Closed principle)
    * want to keep new functionality separate (Single Responsibility Principle)  
* need to be able to interact with existing structures
* Two Options:
    * inherit from required object (if possible, some classes are final)
    * build a Decorator, which simply references the decorated object(s)
* **decorators facilitate the addition of behaviors to individual objects without inheriting from them**

#### Facade
* **exposing several components through a single interface**
* use facade when you have a subsystem that requires dealing with lots of classes and interfaces, and you want to 
provide a simple interface for a client, that provides the same functionality

#### Flyweight
* **space optimization**
* flyweight is used to minimize memory usage or computational expenses by sharing as much as possible with similar objects
* use flyweight if you need a large number of objects of a class where you can easily separate out state that can be
shared and state that can be externalized

#### Proxy
* **a class that functions as an "interface" to a particular resource that needs some added functionality**
* proxies implement the same interface as the real object. It delegates actual functionality to the real object.
    * client is unaware that it is using a proxy
        * proxy performs its work transparently
    
## Behavioral
* behavioral patterns describe how classes and objects interact and communicate with each other

