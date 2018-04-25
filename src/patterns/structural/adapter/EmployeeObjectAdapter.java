package patterns.structural.adapter;

/**
 * An object adapter. Using composition to translate to our required interface
 */
public class EmployeeObjectAdapter implements Customer {

    //the adaptee
    private Employee adaptee;

    //best way to get an adaptee into our object adapter class
    public EmployeeObjectAdapter( Employee employee ) {
        this.adaptee = employee;
    }

    @Override
    public String getName() {
        return adaptee.getFullName();
    }

    @Override
    public String getDesignation() {
        return adaptee.getJobTitle();
    }

    @Override
    public String getAddress() {
        return adaptee.getOfficeLocation();
    }
}
