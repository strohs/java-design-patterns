# Observer
* an observer is an object that wishes to be informed about events happening in the system. The entity generating
the events is an *observable*


## Motivation
* We need to be informed when certain things happen
    * object's field changes
    * Object does something
    * Some external event occurs
* We want to listen to those events and be notified when they occur
* Typical Java pattern involves addXxxListener()
* Java now has functional objects
    * Supplier<T>, Consumer<T>, Function<T>

## Implementation Steps


## Implementation Considerations

    
## Design Considerations


## Example

## Compare
Observer | PATTERN
:---:|:---:   

## Pitfalls


## Summary
* Observer is an intrusive approach
    * an observable must provide an event to subscribe to
* Special care must be taken to prevent issues in multithreaded scenarios
    * especially when it comes to unsubscribing from an event
    