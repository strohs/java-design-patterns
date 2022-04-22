package patterns.creational.factoryMethodInterface;

import patterns.creational.factoryMethodInterface.message.IMessage;

/**
 * This is our "creator" interface.
 * The method createMessage() has to be implemented by implementors.
 */
public interface IMessageCreator {

    //this is the Factory Method
    IMessage createMessage();
}
