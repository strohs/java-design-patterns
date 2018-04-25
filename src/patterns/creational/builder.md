## Builder Pattern

### What problem does builder solve?
* class constructor requires a lot of parameters
    * bad coding practice - try to avoid doing this
* objects that need other objects or *parts* to construct them


### What is a Builder?
* in the builder pattern we remove the logic related to object construction from *client* code and abstract
it into a separate class

### Implementation considerations
* you can easily create an immutable class by implementing builder as an inner static class (see builder2 package)
    * might see this type of implementation quite often out in the wild

### Design Consideration
* the *Director* role is rarely implemented as a separate class, typically the consumer of the object instance
handles that role
* Abstract Builder is also not required if the *product* you are building is not part of any inheritance hierarchy
    * in our code, ```interface UserDTOBuilder``` is our abstract builder
    * you can directly create a concrete builder
* If you are running into a "too many constructor arguments" problem, then the builder pattern *may* help

### Real World Example of Builder patterns
* java.lang.StringBuilder
    * note that it doesn't match 100% with GoF pattern
* java.util.Calendar.Builder (in Java 8)

### Comparison with Prototype pattern

Builder | Prototype
:---:|:---:
we have a complex constructor and Builder allows us to work with that | allows us to skip constructor alltogether
can create Builder as a separate class and so it can work with legacy code | uses java clone() method and needs to modify existing code, so may not work with legacy code

### Pitfalls
* could be considered a little bit complex because of builder method chaining

### Summary
* Consider using the Builder pattern whenever you have a complex constructor or an object is built in multiple steps