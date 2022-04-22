package patterns.structural.bridge;

//A refined abstraction. It uses an implementor in order to provide its functionality
public class Queue<T> implements FifoCollection<T> {

    //uses a LinkedList implementor
    private LinkedList<T> list;

    public Queue( LinkedList<T> list ) {
        this.list = list;
    }

    @Override
    public void offer( T element ) {
        list.addLast( element );
    }

    @Override
    public T poll() {
        return list.removeFirst();
    }
}
