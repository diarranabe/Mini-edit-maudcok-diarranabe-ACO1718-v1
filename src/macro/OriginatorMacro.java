package macro;

class OriginatorMacro {

    private String actionCmd ;
    private char stateValuer  ;
    private int start;
    private int slenght;


    /*
            * Initialisation du momentoMacro
            *
            * */
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
