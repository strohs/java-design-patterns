# Prototype
* you have a complex object that is costly to create
* to create more instances of this complex object, you use an existing instance as a prototype 
* prototype allows you to make copies of an existing object and save us from having to recreate objects from scratch

## Implementing prototype
* start by creating a class that will be the prototype
    * class must implement ```cloneable``` interface
    * class should override ```clone()``` method and return a copy of itself
    * method should declare ```CloneNotSupportedException``` in throws clause to give subclasses a chance to decide
    on whether or not to support cloning
* your clone method implementation should decide to use a deep copy or shallow copy

## Implementation considerations
* pay attention to deep/shallow copy of references. Immutable fields on clones save the trouble of deep copy
* make sure to reset the mutable state of the object before returning the prototype
    * do this in a separate (inherited) method so that subclasses can perform their own reset logic
* clone() method is protected in Object class and must be overridden to be public in order to be callable from outside
the class
* ```Cloneable()``` is a marker interface that indicates a class supports cloning

## Design Considerations
* prototypes are useful when you have large objects where majority of state is unchanged between instances and you can
easily identify that state (immutability etc...)
* prototypes are useful when working with Composite and Decorator patterns

## Real world Examples
* ```Object.clone()``` is an example of prototype
    * it allows any object to act as a prototype
    * classes still need to be cloneable but the method does the job of cloning the object

## Compare and Contrast with Singleton
|                                     Prototype                                      |                          Singleton                          |
|:----------------------------------------------------------------------------------:|:-----------------------------------------------------------:|
|        we return a copy of an instance, meaning we get a different instance        |             we return same instance every time              |
| some or even all of the state of instances created with prototype can be different | since the same object is returned, state is always the same |

## Pitfalls
* usability of prototype depends upon the number of properties that are immutable or that can be shallow copied
* objects with state consisting of large number of mutable objects can be complicated to clone
* java default clone operation only performs shallow copy
    * you must perform any deep copies
* some subclasses may not be able to support clone
    * code becomes complicated as you have to code for situations where an implementation may not support clone

## Summary
* consider prototype pattern whenever you have an object where construction of a new instance is costly or not possible
(object is supplied to your code)
* in Java we can implement prototype pattern using clone() method
* objects which have a majority of immutable state are good candidates for prototypes
* when implementing prototype, pay attention to whether or not you need a deep/shallow copy
* also ensure that the clone is "initialized" (or state is reset) before returning the cloned object