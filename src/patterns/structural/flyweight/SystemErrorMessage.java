package patterns.structural.flyweight;

//A concrete Flyweight. Instance is shared in our system
public class SystemErrorMessage implements ErrorMessage{

    //these two fields are part of our intrinsic state,they will not change, which means they can be shared
    private String messageTemplate; //will contain an $errorCode template that gets replaced with actual error code
    private String helpUrlBase;    //http://somedomain.com/help?error=   errorCode as appended to the end

    public SystemErrorMessage( String messageTemplate, String helpUrlBase ) {
        this.messageTemplate = messageTemplate;
        this.helpUrlBase = helpUrlBase;
    }

    //code is the extrinsic state that will be passed in so we can build the final error message
    @Override
    public String getText( String code ) {
        return messageTemplate.replace( "$errorCode",code ) + helpUrlBase + code;
    }
}
