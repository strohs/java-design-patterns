# Command
* you want to represent a request or a method call as an object. Information about parameters passed and the actual
operation is encapsulated in an object called a "command"
* advantage of the command pattern is, what would have been just a method call, is now an object that can be stored
for later execution or sent to other parts of code
* you could also queue your command objects for later execution


## Implementation Steps
* start by writing the command interface
    * it must define the method which executes the command
* implement the command interface for each request or operation type you need to implement
    * command should also allow for undo operation if your system needs it
* each concrete command knows exactly which operation it needs. All it needs is parameters for the operation, if
required, and the receiver instance on which the operation is invoked    
* client code creates the command instance and sets up the receiver and all required parameters
* the command instance is the ready to be sent to other parts of your code. "Invoker" is the code that actually uses
the command instance and invokes execute on the command


## Implementation Considerations
* you could support "undo" and "redo" in your commands
    * useful for workflow design systems
* if your command are simple (i.e. no undo feature, doesn't have any state ) and simply hides a particular function
and its arguments, then you can reuse the same command object for the same type of request
* for commands that are going to be queued for long durations, pay attention to the size of the state maintained by
them
    
## Design Considerations
* commands can be inherited from other commands in order to reuse portions of code and/or add functionality
* you could also compose commands with other commands. These "macro" commands will have on or more sub-commands
executed in sequence to complete a request
* if you need to implement an undo feature in your command, you can make use of memento design pattern, which will
allow the command to store state of the receiver, without knowing about internal objects used by the receiver

## Example
* java.lang.Runnable uses Command pattern
    * you create an object implementing Runnable, providing all the info. it needs
    * in the run method you call an operation on the receiver
    * you can send this object to other parts of your application for later execution

## Compare   
Command | Strategy
:---:|:---:
command contains the operation to be executed **by the receiver** | strategy actually contains how the operation is to be carried out
command encapsulates an action | strategy encapsulates a particular algorithm


## Pitfalls
* things get tricky when you have to return values or handle errors when using command pattern
* error handling is difficult to implement without coupling the command to the client
    * handling return values also leads to coupling
* if your invoker is running in a different thread, error handling and return values get a lot more complicated
    
## Summary
* command pattern allows you to treat requests for operations as objects
    * this allows you to send these objects to different parts of code for later execution or to a different thread
* commands typically invoke the actual operation on a receiver but contain parameters or information needed for
invocation   
* client code is responsible for creating instances of command and providing it with the receiver and request
information
* commands can also implement an undo feature. In this case the command object will store a snapshot of the receiver
    