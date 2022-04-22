package patterns.structural.flyweight;

//Interface implemented by Flyweights
public interface ErrorMessage {

	//Get error message represented by error code
	String getText( String code );
}
