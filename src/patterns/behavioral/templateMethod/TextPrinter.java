package patterns.behavioral.templateMethod;

import java.util.Map;
import java.util.stream.Collectors;

//Concrete implementation. Implements steps needed by template method
public class TextPrinter extends OrderPrinter {


    @Override
    protected String start() {
        return "Order Details";
    }

    @Override
    protected String formatOrderNumber( Order order ) {
        return String.format( "Order # %s", order.getId() );
    }

    @Override
    protected String formatItems( Order order ) {
        return order.getItems().entrySet().stream()
                .map( entry -> String.format( "%s $%.2f", entry.getKey(), entry.getValue() ) )
                .collect( Collectors.joining("\n") );

    }

    @Override
    protected String formatTotal( Order order ) {
        return String.format( "Total: $%.2f", order.getTotal() );
    }

    @Override
    protected String end() {
        return "";
    }
}
