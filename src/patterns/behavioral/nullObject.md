# Null Object
* A no-op object that conforms to the required interface, satisfying a dependency requirement of some other object


## Motivation
* When component A uses component B, it typically assumes that B is non-null
    * You inject B, not some Option<B> type
    * you do not check for null on every call
* There is no option of telling A *not* to use an instance of B
    * its use is hard-coded
* Thus, we build a no-op non-functioning inheritor of B (or some interface that B implements) and pass it into A


## Implementation Steps
* implement the required interface
* rewrite the methods with empty bodies
    * if method is non-void, return default value for a given type
    * if these values are ever used, you are in trouble
* Supply an instance of Null Object in place of actual object

## Implementation Considerations

    
## Design Considerations


## Example

## Compare
Null Object | PATTERN
:---:|:---:   

## Pitfalls


## Summary
