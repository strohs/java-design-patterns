# Template Method
* define an algorithm in a method as a series of steps (method calls) and provide a chance for subclasses to define or
redefine some of these steps
* the pattern works be defining abstract methods which then have to be implemented be concrete subclasses
    * these methods are like hooks which are then called by the template method
* this pattern allows you to defer implementation of parts of your algorithm which can vary or change
* template methods are an example of the inversion of control principle (Don't call us we'll call you)
    * this is referring to the way template method calls other methods implemented in the subclass(es)

## Motivation


## Implementation Steps
* start by defining your algorithm
    * try to break the algorithm into multiple steps where each step becomes an abstract method
    * try not to create too many steps else it can become tedious to implement in multiple subclasses
* implement the abstract steps in one or more subclasses
    

## Implementation Considerations

    
## Design Considerations


## Example
* Spring Framework JDBCTemplate
* java.util.AbstractMap
* java.util.AbstractSet


## Compare
Template Method | Strategy
:---:|:---:
all subclasses implement steps for the exact same algorithm | each subclass represents a separate algorithm
client code relies solely on inheritance to get a variation of the same algorithm | client code uses composition to configure the "main" class with chosen strategy object
   

## Pitfalls


## Summary
* template method requires that you define the skeleton of an algorithm in a base class
    * typically these steps are defined as abstract methods in the base class
* subclasses of our abstract base class will provide the implementation steps
    * this allows us to have different implementations for the same algorithm
* client code will create an object of one of the concrete subclasses according to whatever algorithm implementation it needs
* factory method design pattern is often implemented as part of template method design pattern
* one drawback of template method is that the various algorithm implementations could be spread across multiple classes
    * this could make it slightly more difficult to understand


    