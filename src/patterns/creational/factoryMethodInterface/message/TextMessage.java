package patterns.creational.factoryMethodInterface.message;

import java.util.HashMap;
import java.util.Map;

public class TextMessage implements IMessage, IHeaderMessage {

    private String message;
    private Map<String, String> headers;

    public TextMessage(String message) {
        this.message = message;
        this.headers = new HashMap<>();
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String getHeader(String headerName) {
        return headers.get(headerName);
    }

    @Override
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override
    public void addDefaultHeaders() {
        this.headers.put("Content-Type", "text/plain");
    }

    @Override
    public void encrypt() {
        // do some sort of encryption to the message
    }
}
