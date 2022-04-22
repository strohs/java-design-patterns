package patterns.creational.factoryMethodInterface.message;

/**
 * This class represents interface for our "product" which is a message
 * Implementations will be specific to content type.
 *
 */
public interface IMessage {

    String getMessage();

    void encrypt();
}
