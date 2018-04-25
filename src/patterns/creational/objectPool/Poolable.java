package patterns.creational.objectPool;


public interface Poolable {

    //state reset, so that any leftover state resets before handing the object out again
    void reset();
}
