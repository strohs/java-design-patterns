package patterns.creational.factoryMethod.message;

/**
 * Example of adding a new message type we want to create with factory method
 * User: Cliff
 */
public class XmlMessage extends Message {

    @Override
    public String getContent() {
        return "<xml att='some dummy attribute'/>";
    }
}
