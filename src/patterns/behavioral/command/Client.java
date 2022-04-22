package patterns.behavioral.command;

public class Client {

	public static void main(String[] args) throws InterruptedException {
        //this could be looked up via JNDI, or Spring Application Context
	    EWSService service = new EWSService();

		Command c1 = new AddMemberCommand( "who@gmail.com", "spam", service );
		MailTasksRunner.getInstance().addCommand( c1 );

        Command c2 = new AddMemberCommand( "you@gmail.com", "spam", service );
        MailTasksRunner.getInstance().addCommand( c2 );

        Thread.sleep( 3000 );

        MailTasksRunner.getInstance().shutdown();
	}

}
