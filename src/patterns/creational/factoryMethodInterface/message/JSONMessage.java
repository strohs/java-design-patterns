package patterns.creational.factoryMethodInterface.message;

public class JSONMessage implements IMessage {

    private String message;

    public JSONMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public void encrypt() {
        // imagine the message gets encrypted
        this.message += "Encrypted....";
    }
}
