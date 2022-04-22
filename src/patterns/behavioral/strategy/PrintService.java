package patterns.behavioral.strategy;


import java.util.LinkedList;

//Context 
public class PrintService {

    //holds the strategy to use
    private OrderPrinter printer;

    public PrintService( OrderPrinter orderPrinter ) {
        this.printer = orderPrinter;
    }

    public void printOrders( LinkedList<Order> orders ) {
        printer.print( orders );
    }
}
