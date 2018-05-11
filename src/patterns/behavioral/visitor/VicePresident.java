package patterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class VicePresident extends AbstractEmployee{

	private List<Employee> directReports = new ArrayList<>();

	public VicePresident(String name, Employee...employees) {
		super(name);
        directReports.addAll( Arrays.asList( employees ) );
	}
	
	@Override
	public Collection<Employee> getDirectReports() {
		return directReports;
	}

	@Override
	//can implement accept in AbstractEmployee because using "this" would return AbstractEmployee
	public void accept( Visitor visitor ) {
		visitor.visit( this );
	}

}
