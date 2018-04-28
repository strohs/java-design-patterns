package patterns.behavioral.interpreter;

//Terminal expression

public class Permission implements PermissionExpression {

    private String permission;

    public Permission( String permission ) {
        this.permission = permission.toLowerCase();
    }

    @Override
    public boolean interpret( User user ) {
        //if permission is found, then we can say this terminal expression is true
        return user.getPermissions().contains( permission );
    }

    @Override
    public String toString() {
        return permission;
    }
}
