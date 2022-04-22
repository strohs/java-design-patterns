package patterns.creational.factoryMethod.message;

//concrete implementation of Message
public class JSONMessage extends Message {

	@Override
	public String getContent() {
		return "{\"JSON]\":[]}";
	}
	
}
