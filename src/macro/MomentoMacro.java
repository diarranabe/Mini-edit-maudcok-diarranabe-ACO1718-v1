package macro;

import receiver.Selection;

public class MomentoMacro {

    private String actionCmd;
    private char stateValuer;
    private int start;
    private int slenght;

    public MomentoMacro(String actionCmd, char stateValuer, int start, int slenght) {
        this.actionCmd = actionCmd;
        this.stateValuer = stateValuer;
        this.start = start;
        this.slenght = slenght;
    }

    public String getActionCmd() {
        return actionCmd;
    }

    public char getStateValuer() {
        return stateValuer;
    }

    public int getStart() {return start;  }

    public int getLenght() {return slenght;}


}
