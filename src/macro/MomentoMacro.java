package macro;

import receiver.Selection;

public class MomentoMacro {

    private final String actionCmd;
    private final char stateValuer;
    private final int start;
    private final int slenght;

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
