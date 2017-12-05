package macro;

class OriginatorMacro {

    private String actionCmd ;
    private char stateValuer  ;
    private int start;
    private int slenght;



    /**
     *
     * @param actionCmd  type d'action effectue par l'utilisateur
     * @param stateValuer le contenu ou la valeur de l'action
     * @param start la position du curseur
     * @param slenght prochqinne position de l'utilisateur
     */
    public void setAction(String actionCmd, char stateValuer, int start, int slenght) {
        this.stateValuer = stateValuer;
        this.start =start;
        this.slenght =slenght;
        this.actionCmd = actionCmd ;
        System.out.println(start + " " );

    }

    /*
    * Enregistrement du momento
    * */
    public MomentoMacro storeMomento() {
        return new MomentoMacro(actionCmd,stateValuer,start,slenght);
    }

    /*
    * Recuperation de l'etat du momento
    * */
    public char restoreMacroStateValue(MomentoMacro momento) {
        stateValuer = momento.getStateValuer();
        return stateValuer;
    }

    public int restoreMacroSart(MomentoMacro momento) {
        start = momento.getStart();
        return start;
    }

    public int restoreMacroLenghtn(MomentoMacro momento) {
        slenght = momento.getLenght();
        return slenght;
    }

    public String restoreMacroAction(MomentoMacro momento) {
        actionCmd = momento.getActionCmd();
        return actionCmd;
    }

}
