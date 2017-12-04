package momento;

import receiver.Buffer;
import receiver.PressePapiers;
import receiver.Selection;

public class Momento {

    private String stateValuer ;
    private Selection select ;

 //   private  Command commandState ;


    public Momento(String stateValuer, Selection select) {
        this.stateValuer = stateValuer;
        this.select = select;
    }

    public String getStateValuer() {
        return stateValuer;
    }

    public Selection getSelect() {
        return select;
    }

}
