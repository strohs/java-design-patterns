package patterns.structural.bridge;

//This is the implementor. 
//Note that this is also an interface
//As the implementor, it is defining its own hierarchy which is not related at all to the abstraction hierarchy.
//It provides operations that can be used by our abstraction to provide desired functionality
public interface LinkedList<T> {
	
	void addFirst( T element );
	
	T removeFirst();
	
	void addLast( T element );
	
	T removeLast();
	
	int getSize();
}
