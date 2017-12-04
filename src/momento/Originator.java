package momento;

import receiver.Selection;

class Originator {

    private String stateValuer  ;
    private Selection select = new Selection() ;

    /*
    * Initialisation du momento
    * */
    public void setSubject(String stateValuer,int start ,int lenght) {
        this.stateValuer = stateValuer;
        this.select.setStart(start);
        this.select.setLength(lenght);
    }

    /*
    * Enregistrement du momento
    * */
    public Momento storeMomento() {
        return new Momento(stateValuer,select);
    }

    /*
    * Recuperation de l'etat du momento
    * */
    public String restoreMomentoStateValue(Momento momento) {
        stateValuer = momento.getStateValuer();
        return stateValuer;
    }

    public Selection restoreMomentoSelection(Momento momento) {
        select = momento.getSelect();
        return select;
    }

}
