# Singleton
* a singleton class has only one instance
* accessible gobally thru a single point (via a method or field)
* singleton ensures that only a single instance of a class exists
* any state you add in your singleton becomes part of "global state" of your application

## Implementation
* control instance creation
    * class constructors must not be accessible globally
    * subclassing/inheritance must not be allowed
* keep track of the singleton instance
    * class itself is a good place to track the instance
* giving access to the singleton instance
    * a public static method is a good choice
    * can expose instance as a final public static field but it won't work for all singleton implementations
* two options for implementing a singleton
    * early initialization - Eager singleton
        * create the singleton as soon as class is loaded
    * lazy initialization
        * singleton is created when it is first required

## Implementation Considerations
* Early/Eager initialization is the simplest and preferred way to create singletons, try this first
* the "classic" singleton pattern impl. uses double check locking and volatile field
* the lazy initialization holder idiom provides best of both worlds
    * you don't have to deal with synchronization issues, and it's easy to implement
* you can also implement singletons using enums, but this could be a "hard-sell" due to pre-conceptions about
what an enum is/should be used for (especially if singleton has immutable fields)

## Design considerations
* singleton creation does not need any parameters
    * if you need support for constructor arguments, you should use a simple factory or factory method
* make sure your singletons are NOT carrying a lot of mutable global state

## Examples
* java.lang.Runtime

## Comparison with Factory Method
Singleton | FactoryMethod
:---:|:---:
primary purpose is to ensure only one instance of class is created | primarily used to isolate client code from object creation and delegate object creation to subclasses
created without any need of arguments from client code | allows you to parameterize object creation


## Pitfalls
* since singleton instance is available globally, it can become a dependency to multiple objects in your code base
* they are hard to unit test. You cannot easily mock the instance that is returned
* most common way to implement Singletons in Java is through static variables and they are held per class loader
and not per JVM. So they may not truly be Singleton in an OSGi or web application
* a singleton carrying around a large **mutable** global state is a good indication of an abused singleton pattern
    * this is a bad design practice

## Summary
* you want to ensure there is one instance of a class throughout your application
* in java we achieve this via a private constructor, which also prevents inheritance
* 2 choice for implementing singleton
    * eager loading - create instance as soon as class is loaded by classloader
    * lazy loading - defer creating singleton until a class actually needs it
* always prefer eager singleton (if you can) as it avoids many complexities of other singletons (like synchronization)
    * note that eager singletons can add to your start-up time
* there are very few situations where a Singleton is a really good choice
* application configuration values can be tracked in a singleton
    * typically these are read from a file at start time and then referred to by other parts of your application
* logging frameworks (log4j) make use of singleton 
* Spring treats all beans as singletons by default, it handles creating the beans as singletons 