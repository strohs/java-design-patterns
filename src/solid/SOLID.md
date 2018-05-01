# S.O.L.I.D. Design Principles

## Single Responsibility Principle
* A single class should have one primary responsibility


## Open Closed Principle
* A class should be open for extension but closed for modification
    * extension via Interfaces or Inheritance
    * you should avoid modifying code that has already been written (and tested)

## Liskov Substitution Principle
* you should be able to substitute a subclass for a base class
    * ensures that inheritance is being used correctly
* violations will often fail the "is a " test
    * a Square "is a" Rectangle but a Rectangle is not a Square

    
## Interface Segregation Principle
* recommendation on how to split interfaces into smaller interfaces
* many client specific interfaces are better than one "general purpose" interface
* goal is to avoid having a class implement interfaces it doesn't need

## Dependency Inversion Principle
* High level modules should not depend on low-level modules
    * both should depend on abstractions
        * abstraction here means an abstract class or an interface
* Abstractions should not depend on details
    * details should depend on abstractions
    * if you can use abstract classes and interfaces then use them
    
    

