package patterns.creational.factoryMethod;


import patterns.creational.factoryMethod.message.Message;
import patterns.creational.factoryMethod.message.TextMessage;

/**
 * Provides implementation for creating Text messages
 */
public class TextMessageCreator extends MessageCreator {


    @Override
    public Message createMessage() {
        return new TextMessage();
    }
}
