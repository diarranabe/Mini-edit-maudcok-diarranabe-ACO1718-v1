package momento;

import receiver.Selection;

public class Momento {

    private String stateValuer  ;
    private Selection select ;

    /**
     *
     * @param stateValuer
     * @param select
     */
    public Momento(String stateValuer, Selection select) {
        this.stateValuer = stateValuer;
        this.select = select;
    }

    public String getStateValue() {
        return stateValuer;
    }

    public Selection getSelect() {
        return select;
    }

}
