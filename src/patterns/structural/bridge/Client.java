package patterns.structural.bridge;

public class Client {

	public static void main(String[] args) {
		FifoCollection<Integer> collection = new Queue<>( new SinglyLinkedList<>() );
		collection.offer( 11 );
		collection.offer( 22 );
		collection.offer( 33 );
        System.out.println( collection.poll() );
        System.out.println( collection.poll() );
        System.out.println( collection.poll() );
        //
        System.out.println( collection.poll() );
	}

}
