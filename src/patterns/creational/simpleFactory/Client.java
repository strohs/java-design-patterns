package patterns.creational.simpleFactory;

public class Client {

	public static void main(String[] args) {
		//Post post = PostFactory.createdPost( "blog" );
        Post post = PostFactory.createdPost( "news" );
		System.out.println( post );
	}

}
