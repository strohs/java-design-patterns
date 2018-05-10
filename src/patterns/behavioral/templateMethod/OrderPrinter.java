package patterns.behavioral.templateMethod;

import java.io.IOException;
import java.io.PrintWriter;

//Abstract base class that defines the template method
public abstract class OrderPrinter {

    //final because we do not want subclasses to change how printOrder is implemented
    public final void printOrder( Order order, String filename ) throws IOException {
        try( PrintWriter writer = new PrintWriter( filename ) ) {
            writer.println( start() );
            writer.println( formatOrderNumber( order ) );
            writer.println( formatItems(order) );
            writer.println( formatTotal(order) );
            writer.println( end() );
        }
    }

    protected abstract String start();

    protected abstract String formatOrderNumber( Order order );

    protected abstract String formatItems( Order order );

    protected abstract String formatTotal( Order order );

    protected abstract String end();

}
