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
* a context is passed to interpreter. It typically will have the sentence to be interpreted and optionally it may
also be used by interpreter to store any values that the expressions need/modify/populate 

## Implementation Considerations
* you have to implement the parsing of your "language". The pattern doesn't discuss how to parse and build your AST
* context object can be used to store and access state of the interpreter
    
## Design Considerations
* you can use visitor pattern to interpret instead of adding interpret method in expression classes
* can also use flyweight pattern for terminal expressions (they can often be reused)

## Example
* java.util.regex.Pattern
    * a Pattern instance is created with an internal abstract syntax tree, when the static "compile()" method is called
    

## Compare
Interpreter | Visitor
:---:|:---:
represents language rules or grammar as object structure | represent operations to be performed on an existing object structure
has access to properties it needs for doing interpretation | needs an observable and observer functionality to gain access to properties
 
   
## Pitfalls
* class per rule can result in a large number of classes getting created
* not suitable for languages with complex grammar rules
* this pattern is very specific to the problem of interpreting a simple language

## Summary
* you want to parse a language with grammar rules
* each rule in the language becomes an expression class in the interpreter pattern
    * a terminal expression provides implementation of interpret method
    * a non-terminal expression holds other expressions and calls interpret on its children
* no guidance on how to build you Abstract Syntax Tree, you decide how to do this