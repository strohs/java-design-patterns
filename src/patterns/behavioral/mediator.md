# Mediator
* mediator encapsulates how a set of objects interact with each other
    * due to this encapsulation, there is a loose coupling between the interacting objects
* typically an object explicitly knows about another object that it want to interact with (i.e. call a method on it)
    * in the mediator pattern, this interaction is within the mediator object
    * interacting objects only know about the mediator object
* the benefit of mediator is that the interaction can now change without needing modifications to participating
objects. Changing the mediator allows you to add/remove participants in an interaction



## Implementation Steps
* start by defining the mediator
    * mediators define a generic method which is called by other objects
        * this method typically needs to know which object changed and optionally the exact property which has changed in
        that object
        * implement this method in which we notify other objects about the state change
* mediator needs to know about all participants in the collaboration it is mediating
    * to solve this problem, you can either have objects register with the mediator or the mediator itself can create
    these objects
* depending on your particular implementation, you may need to handle the infinite loop of change-notify-change 
    * this can result if object's value change handler is called for every value change, whether from an external source as well as
    from the mediator
 

## Implementation Considerations
* it's important that the mediator knows which object sent the change notification to avoid sending that object the
changed value again
* if an object takes a long time to process a change, it can affect overall performance of the mediator severely.
    * this is a common problem in any notification system so pay attention to any synchronization you do in mediator methods
* you often end up with a complex mediator since it becomes a central point that handles all routing between objects
    * this can make it difficult to maintain the mediator as your complexity grows
        
## Design Considerations
* you can extend mediator and create variations to be used in different situations, like platform dependant interactions
* an abstract mediator class is often not required if participating objects only work with that one mediator
* you could use the observer pattern to implement the notification system that objects use to notify the mediator

## Example
* javax.swing.ButtonGroup
    * it makes sure that only one button in a button group is selected
    * participating "buttons" notify this mediator when they are selected
* sometimes a front controller is given as a example of a mediator (DispatcherServlet in spring)
    * however in GoF mediator, a mediator notifies all other objects when an object changes

## Compare 
Mediator | Observer
:---:|:---:  
intent is to encapsulate complex interaction between objects | intent is to define one-to-many relationship between objects
mediator implementations are typically specific to objects being mediated | observer pattern implementations are **generic**. Once implemented it can be used with any class


## Pitfalls
* mediator is a central control object for multiple objects, as complexity grows, mediator code can get out of hand
* mediators are typically very specific to the collaboration they are mediating. Making a mediator that can be reused
with multiple sets of different objects can be a challenge

## Summary
* you want to decouple a group of objects which communicate with each other
* each object only knows about the mediator object and notifies it about changes in its state
    * mediator will then notify other objects on its behalf
* mediators are typically specific (and coupled) to a collaboration. it's difficult to write re-usable mediator
    * observer pattern solves this problem; however, mediators are easy to implement and extend
* defining characteristic of a mediator is that it streamlines the communication between multiple objects
    * so a class which simply calls methods on multiple objects can't be a mediator (according to GoF definition)