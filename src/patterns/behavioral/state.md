# State Pattern
* a pattern in which the object's behavior is determined by its state. An object transitions from one state to
another (something needs to trigger a transition)
* a formalized construct which manages state and transitions is called a state machine

## Motivation
* Consider an ordinary telephone
* what you do with it depends in the state of the phone/line
    * if it's ringing, or you want to make a call, you can pick it up
    * phone must be off the hook to talk/make a call
    * if you try calling someone, and it's busy, you put the handset down
* changes in state can be explicit or in response to an event (Observer Pattern)


## Implementation Steps


## Implementation Considerations

    
## Design Considerations


## Example

## Compare
State | PATTERN
:---:|:---:   

## Pitfalls


## Summary
* Given sufficient complexity, it pays to formally define possible states and events/triggers
* you can define:
    * State entry/exit behaviors
    * Action when a particular event causes a transition
    * Guard conditions enabling/disabling a transition
    * Default actions when no transitions are found for an event