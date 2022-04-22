package patterns.creational.factoryMethodInterface;

import patterns.creational.factoryMethodInterface.message.IMessage;
import patterns.creational.factoryMethodInterface.message.JSONMessage;

public class JSONMessageCreator implements IMessageCreator {

    @Override
    public IMessage createMessage() {
        String message = String.format("{"+ "\"message\": \"%s\"}", "this is the JSON message");
        return new JSONMessage(message);
    }
}
