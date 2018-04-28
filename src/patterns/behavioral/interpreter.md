# Interpreter
* use interpreter when you want to process a **simple** "language" with rules or grammar
    * e.g. "file access requires user role and admin role"
        * suppose this is a simple language that can be interpreted by our interpreter
* interpreter allows us to represent the rules of a language or grammar in a data structure and then interpret
sentences in that language
* each class in this pattern represents a rule in the language
    * classes also provide a method to interpret and expression    


## Implementation Steps
* start by studying the rules of the language for which you want to build an interpreter
    * define an abstract class or interface to represent and expression and define a method in it which interprets the expression
    * each rule in the class becomes an expression
        * expressions which do not need other expressions to interpret become terminal operations
    * create non-terminal expression classes which contain other expressions
        * these will in turn call interpret on children as well as perform interpretation of their own
* building the abstract syntax tree using these classes can be done by the client itself, or done in a separate class
* client will then use this abstract syntax tree to interpret a sentence 

## Implementation Considerations

    
## Design Considerations


## Example

## Compare
Interpreter | PATTERN
:---:|:---:
   

## Pitfalls


## Summary
