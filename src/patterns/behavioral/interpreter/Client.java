package patterns.behavioral.interpreter;

public class Client {

	public static void main(String[] args) {
		Report report1 = new Report( "Cashflow Report", "FINANCE_ADMIN OR ADMIN" );
		ExpressionBuilder builder = new ExpressionBuilder();

		PermissionExpression exp = builder.build( report1 );
        System.out.println( exp );

        User user1  = new User( "Dave", "USER");
        System.out.println("User Access Repost:" + exp.interpret( user1 ) );
	}

}
