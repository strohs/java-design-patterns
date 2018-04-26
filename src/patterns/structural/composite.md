# Composite Pattern
* you have a part-whole relationship or hierarchy of objects and you want to treat all objects in this hierarchy uniformly
    * eg. a Tree structure and you want to treat objects the same whether a leaf node or non-leaf node (composite)
* this is NOT a simple composition concept from OO-programming, but a further enhancement to that concept
* think of composite pattern when dealing with a tree structure of objects

## Implementation
* start by creating an abstract class / interface for the Component
    * component must declare all methods that are applicable to both leaf and composite
    * you have to choose who defines the children management operations, component or composite
    * implement the composite
        * an operation on the composite is propagated to all its children
        * leaf nodes have to handle the non-applicable operations like add/remove a child if they are defined in component
* in the end, a composite pattern implementation will allow you to write algorithms without worrying about whether a
node is a leaf or composite

## Implementation Considerations
* you can provide a method to access parent of a node
    * this will simplify traversal of the entire tree
* you can define the collection that maintains the child objects in the base component instead of the composite, but
then again that field has no use in a leaf class
* If leaf objects can be repeated in the hierarchy, then shared leaf nodes can be used to save memory and initialization
costs.
    * the number of leaf nodes is a major deciding factor, as using a cache for a small number of nodes may cost more
 
## Design Considerations
* A decision will need to be made about where child management operations are defined.
    * defining them in the component class provides transparency but leaf nodes are forced to implement those methods
    * defining them in the composite class is safer but the client class will need to be made aware of composite
* overall goal of the design should be to make client code easier to implement when using your composite class
    * this is possible if client code can work with component interface **only** and doesn't need to worry about
    constantly checking to see if an object is a leaf or composite

## Example of Composite Pattern
* many UI frameworks, since you usually need to represent a tree of UI controls
    * Java Server Faces ```UIViewRoot``` is a composite. ```UIOutput UIMessage``` act as leaf nodes
    
## Compare and Contrast with Decorator
Composite | Decorator
:---:|:---:
deals with tree structure of objects | simply contains another (single) object
leaf nodes and composites have same interface and composites simple delegate the operation to children | add or modify the behavior of the contained object and do not have the notion of children

## Pitfalls
* Difficult to restrict what is added to the hierarchy
    * if multiple leaf nodes are present in the system then client code ends up doing runtime checks to ensure the
    operation is available on a node
* creating the original hierarchy can still be a complex operation
    * the pattern doesn't tell you how to build your tree, it is for working with an already built tree
    * especially if you are using caching to reuse nodes and number of nodes is large

## Summary
* you have a parent-child relationship or whole-part relationship between objects. You can use composite pattern to
simplify dealing with such object arrangements
* Goal of composite pattern is to simplify the client code by allowing it to treat the composites and leaf nodes
in the same way
* composite classes will delegate operations to its children while leaf nodes implement the functionality
* you have to decide which methods the base component will define
    * adding all methods here will allow client to treat all nodes the same
        * but it may force classes to implement behavior which they don't have