# Strategy
* Strategy allows us to encapsulate an algorithm in a class
    * you can then configure your context (or main object) with an object of this class, to change the algorithm used
    to perform a given operation
* very helpful if you have many possible variations of an algorithm (like searching, or sorting)
* a good indication for applicability of the strategy pattern is if you find different algorithms/behaviors in your
methods which are selected with conditional statements like if-else or switch-case
* strategy classes are usually implemented in an inheritance hierarchy so that we can choose any one implementation and
it'll work with our main object/context, (as the interface is the same for all implementations)

## Motivation
* OVERVIEW - enables the exact behavior of a system to be selected either at run-time (dynamic) or compile-time (static)
* many algorithms can be decomposed into higher and lower level parts
* For example: making tea can be decomposed into:
    * higher level: making hot beverages in general (boil water, pour into cup,...) and
    * tea specific: put teabag into water
* the high level algorithm can then be reused for making coffee or hot chocolate
    * supported by beverage specific strategies

## Implementation Steps
* Define an algorithm at a high level
* Define the interface you expect each strategy to follow
* Provide for either *dynamic* or *static* composition of strategy in the overall algorithm

## Implementation Considerations

    
## Design Considerations


## Example
* java.util.Comparator - great example of Strategy pattern

## Compare
Strategy | State
:---:|:---: 
create a class per algorithm | you have a class per state
strategy objects do not need to know about each other | if states are responsible for triggering state transitions, then they have to know about the next state (at the least)  


## Pitfalls


## Summary
