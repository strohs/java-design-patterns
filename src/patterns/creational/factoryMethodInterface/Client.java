package patterns.creational.factoryMethodInterface;

import patterns.creational.factoryMethodInterface.message.IMessage;

/**
 * Creates differnt types of message using the factory method pattern, but implemented as interfaces instead
 * of abstract classes
 */
public class Client {

    public static void main(String[] args) {
        IMessageCreator textCreator = new TextMessageCreator();
        IMessageCreator jsonCreator = new JSONMessageCreator();

        IMessage textMessage = textCreator.createMessage();
        IMessage jsonMessage = jsonCreator.createMessage();

        Client.printMessage(textMessage);
        Client.printMessage(jsonMessage);
    }

    public static void printMessage( IMessage msg ) {
        System.out.println( msg.getMessage() );
    }
}
