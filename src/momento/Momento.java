package momento;


import receiver.Selection;

public class Momento {

    private final String stateValuer;
    private final Selection select;

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
