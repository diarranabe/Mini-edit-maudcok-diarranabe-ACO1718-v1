package macro;

import receiver.Selection;

public class OriginatorMacro {

    private String actionCmd ;
    private char stateValuer  ;
    private int start;
    private int slenght;


    /*
            * Initialisation du momentoMacro
            *
            * */
    public void setAction( String actionCmd, char stateValuer,int start ,int lenght) {
        this.stateValuer = stateValuer;
        this.start =start;
        this.slenght =slenght;
        this.actionCmd = actionCmd ;
        System.out.println(start + " " + slenght );

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
