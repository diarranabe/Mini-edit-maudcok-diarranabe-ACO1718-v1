package momento;

import receiver.Selection;

class Originator {

    private String stateValue;
    private Selection selection = new Selection() ;

    /**
     * Initialisation du momento
     * @param stateValue
     * @param start
     * @param lenght
     */
    public void setSubject(String stateValue,int start ,int lenght) {
        this.stateValue = stateValue;
        this.selection.setStart(start);
        this.selection.setLength(lenght);
    }

    /**
     * Enregistrement du momento
     * @return
     */
    public Momento storeMomento() {
        return new Momento(stateValue, selection);
    }

    /**
     * Recuperation de l'etat du momento
     * @param momento
     * @return
     */
    public String restoreMomentoStateValue(Momento momento) {
        stateValue = momento.getStateValue();
        return stateValue;
    }

    /**
     * Recupération de la selection
     * @param momento
     * @return
     */
    public Selection restoreMomentoSelection(Momento momento) {
        selection = momento.getSelect();
        return selection;
    }
}
