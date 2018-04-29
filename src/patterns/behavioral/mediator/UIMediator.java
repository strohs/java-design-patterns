package patterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

//Mediator
public class UIMediator {

    List<UIControl> colleagues = new ArrayList<>( );

    public void register( UIControl control ) {
        colleagues.add( control );
    }

    public void valueChanged(UIControl control) {
        //notify other controls, that a control has changed
        colleagues.stream().filter( cntrl -> cntrl != control ).forEach( cntrl -> cntrl.controlChanged( control ) );

    }
}
