package patterns.creational.factoryMethodInterface;

import patterns.creational.factoryMethodInterface.message.IMessage;
import patterns.creational.factoryMethodInterface.message.TextMessage;

public class TextMessageCreator implements IMessageCreator {

    @Override
    public IMessage createMessage() {
        TextMessage msg = new TextMessage("this is the text message");
        //may want to do some additional processing on text messages
        msg.addDefaultHeaders();
        msg.encrypt();

        return msg;
    }
}
