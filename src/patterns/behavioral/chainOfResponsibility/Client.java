package patterns.behavioral.chainOfResponsibility;

import java.time.LocalDate;

public class Client {

	public static void main(String[] args) {
	    LeaveApplication application = LeaveApplication.getBuilder()
                .withType( LeaveApplication.Type.Sick )
                .from( LocalDate.now() )
                .to( LocalDate.of( 2018,5,8 ))
                .build();

        System.out.println( application );
	    LeaveApprover approverChain = createChain();
	    approverChain.processLeaveApplication( application );
        System.out.println( application );
	}

	//create the chain of responsibility
    // lead => manager => director => null
	private static LeaveApprover createChain() {
	    Director director = new Director( null );
	    Manager manager = new Manager( director );
	    ProjectLead lead = new ProjectLead( manager );
	    return lead;
	}
}
