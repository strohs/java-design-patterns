package patterns.creational.factoryMethod.message;

//concrete implementation of Message
public class TextMessage extends Message {
	
	@Override
	public String getContent() {
		return "Text";
	}
	
}
