package patterns.behavioral.chainOfResponsibility;

//A concrete handler
public class ProjectLead extends Employee {

    
    public ProjectLead( LeaveApprover successor ) {
        super( "Project Lead", successor );
    }

    @Override
    protected boolean processRequest( LeaveApplication application ) {
        //project lead can process a request if type is sick leave and duration <= 2 days
        if ( application.getType() == LeaveApplication.Type.Sick ) {
            if ( application.getNoOfDays() <= 2 ) {
                application.approve( getApproverRole() );
                return true;
            }
        }
        return false;
    }
}
