# Simple Factory Pattern

## What problem does simple factory solve?
* multiple types can be instantiated and the choice is based on some simple criteria

## What is Simple Factory?
* Here we simply move the instantiation logic to a separate class
    * commonly to a static method of the class
* Some may not consider Simple Factory a design pattern at all, as it is simply a method that encapsulates
object instantiation. Nothing complex goes on in that method
* Simple Factory should not be confused **factory method** pattern
* typically we want to use this if we have more than one option when instantiating an object and simple logic is
used to choose the correct class

## Implementing Simple Factory
* start by creating a separate class for our simple factory
    * add a method which returns desired object instance
        * this method is typically static and will accept some arguments to decide which class to instantiate
        * can also provide additional arguments which will be used to instantiate objects

## Implementation Considerations
* Simple factory itself doesn't need any state tracking so it's best to keep this as a static method

## Design Considerations
* simple factory may in turn use other design patterns like Builder to construct objects
* in case you want to specialize your simple factory in sub classes, then use factory method pattern

## Real World Examples
* java.text.NumberFormat
    * has getInstance method (which is an example of simple factory)

## Compare and Contrast with SimpleFactory
|                                    SimpleFactory                                    |                            FactoryMethod                            |
|:-----------------------------------------------------------------------------------:|:-------------------------------------------------------------------:|
| instantiation logic is moved away from client code (typically into a static method) | more useful when you want to delegate object creation to subclasses |
|                 knows about all classes whose objects it can create                 |         don't know in advance about all product subclasses          |

## Pitfalls
* criteria used to decide which object to instantiate can get more complex over time, if this happens you should use
factory method design pattern instead

## Summary
* simple factory encapsulates object instantiation into a separate method (usually in another class)
* one (or more) arguments are passed to the method to determine what object to create