package patterns.structural.adapter;

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
