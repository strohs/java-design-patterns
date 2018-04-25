package patterns.creational.factoryMethod;


import patterns.creational.factoryMethod.message.Message;

/**
 * This is our abstract "creator". 
 * The abstract method createMessage() has to be implemented by
 * its subclasses.
 */
public abstract class MessageCreator {

    public Message getMessage() {
        Message msg = createMessage();
        //may want to do some additional processing on the message
        msg.addDefaultHeaders();
        msg.encrypt();
        
        return msg;
    }

    //this is the Factory Method
    public abstract Message createMessage();

    //the createMessage method could also be protected when you want callers to use getMessage() to create Messages
    //so that additional processing is done
    //protected abstract Message createMessage();
}
