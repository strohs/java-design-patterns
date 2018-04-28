package patterns.behavioral.interpreter;

public class Report {

	private String name;

	//examples of permission expressions: "NOT ADMIN", "FINANCE_USER AND ADMIN"
	private String permission;
	
	public Report(String name, String permissions) {
		this.name = name;
		this.permission = permissions;
	}

	public String getName() {
		return name;
	}

	public String getPermission() {
		return permission;
	}
	
	
}
