package patterns.behavioral.visitor;


public class PrintVisitor implements Visitor {


    @Override
    public void visit( Programmer programmer ) {
        String msg = String.format( "%s is a %s programmer", programmer.getName(), programmer.getSkill() );
        System.out.println( msg );
    }

    @Override
    public void visit( ProjectLead projectLead ) {
        String msg = String.format( "%s is a project lead with %d programmers reporting", projectLead.getName(), projectLead.getDirectReports().size() );
        System.out.println( msg );
    }

    @Override
    public void visit( Manager manager ) {
        String msg = String.format( "%s is a manager with %d leads", manager.getName(), manager.getDirectReports().size() );
        System.out.println( msg );
    }

    @Override
    public void visit( VicePresident vicePresident ) {
        String msg = String.format( "%s is a Vice President with %d managers reporting", vicePresident.getName(), vicePresident.getDirectReports().size() );
        System.out.println( msg );
    }
}
