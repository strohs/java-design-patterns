package patterns.creational.factoryMethod;

import patterns.creational.factoryMethod.message.Message;
import patterns.creational.factoryMethod.message.XmlMessage;

/**
 * User: Cliff
 */
public class XmlMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new XmlMessage();
    }
}
