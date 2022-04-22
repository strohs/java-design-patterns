package patterns.behavioral.command;

//A Concrete implementation of Command.
//This class adds a member to the EWSServer
public class AddMemberCommand implements Command {

    private String emailAddress;

    private String listName;

    //this could be looked up via JNDI, or Spring Application Context, but in this case we get it from constructor
    private EWSService receiver;

    public AddMemberCommand( String emailAddress, String listName, EWSService receiver ) {
        this.emailAddress = emailAddress;
        this.listName = listName;
        this.receiver = receiver;
    }


    @Override
    public void execute() {
        receiver.addMember( emailAddress, listName );
    }
}
