package patterns.creational.factoryMethod;


import patterns.creational.factoryMethod.message.JSONMessage;
import patterns.creational.factoryMethod.message.Message;

/**
 * Provides implementation for creating JSON messages
 */
public class JSONMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new JSONMessage();
    }
}
