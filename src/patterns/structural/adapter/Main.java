package patterns.structural.adapter;

/**
 * in this example we want to use the BusinessCardDesigner to design a card. It expects a Customer object as input, but
 * we currently only have the Employee object.  So we need an adapter to adapt Employee to a customer. So we create
 * an Employee*Adapter, that takes an employee as input, and adds Customer interface functionality to it.
 */
public class Main {

	public static void main(String[] args) {
		/** Using Class/Two-way adapter **/
		EmployeeClassAdapter adapter = new EmployeeClassAdapter();
		populateEmployeeData( adapter );                //two way adapter call 1
		BusinessCardDesigner designer = new BusinessCardDesigner();
		String card = designer.designCard( adapter );   //two way adapter call 2
        System.out.println( card );

        System.out.println("=================================================");

        /** Using Object Adapter **/
        Employee employee = new Employee();
        populateEmployeeData( employee );
        EmployeeObjectAdapter objectAdapter = new EmployeeObjectAdapter( employee );
        card = designer.designCard( objectAdapter );
        System.out.println( card );
	}

	private static void populateEmployeeData(Employee employee) {
		employee.setFullName("Elliot Alderson");
		employee.setJobTitle("Security Engineer");
		employee.setOfficeLocation("Allsafe Cybersecurity, New York City, New York");
	}
}
