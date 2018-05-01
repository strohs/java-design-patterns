# Memento
* keep a "memento" of an object's state to return to that state

## Motivation
* an object or system goes through changes
    * e.g. a bank account gets deposits and withdrawals
* there are different ways of navigating those changes
    * one way is to record every change (Command) and teach a command to undo itself
* another way is to simply save snapshots of the system and then allow the user to rollback to a particular snapshot
* Memento - a token/handle representing system state. Lets us roll back to the state when the token was generated.
May or may not directly expose state information


## Implementation Steps


## Implementation Considerations

    
## Design Considerations


## Example
* undo support provided by javax.swing.text.JTextComponent

## Compare 
Memento | PATTERN
:---:|:---:  

## Pitfalls


## Summary
* mementos are used to rollback state arbitrarily
* a memento is simply a token/handle class with (typically) no functions of its own
* A memento is not required to expose directly the state(s) to which it reverts the system
* can be used to implement undo/redo