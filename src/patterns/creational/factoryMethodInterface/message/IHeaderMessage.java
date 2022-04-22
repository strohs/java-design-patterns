package patterns.creational.factoryMethodInterface.message;

import java.util.Map;

/**
 * An example interface for messages that contain headers
 */
public interface IHeaderMessage {

    /**
     * @param headerName - the name of the header to retrieve
     * @return the value associated with headerName
     */
    String getHeader(String headerName);

    /**
     *
     * @return a map containing all the headers and their associated values
     */
    Map<String,String> getHeaders();

    /**
     * adds one or more default headers to a message
     */
    void addDefaultHeaders();
}
