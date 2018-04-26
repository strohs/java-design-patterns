package patterns.structural.decorator;

import org.apache.commons.text.StringEscapeUtils;

//Decorator. Implements component interface (Message)
// this class will decorate a message with HtmlEncoding functionality
public class HtmlEncodedMessage implements Message {

    //will hold a reference to a concrete component
    private Message msg;

    public HtmlEncodedMessage( Message msg ) {
        this.msg = msg;
    }

    @Override
    public String getContent() {
        //decorator is adding escape text functionality
        return StringEscapeUtils.escapeHtml4( msg.getContent() );
    }
}
