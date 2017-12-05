package macro;

public class MomentoMacro {

    private final String actionCmd;
    private final char stateValuer;
    private final int start;
    private final int slenght;

    /**
     *
     * @param actionCmd  type d'action effectue par l'utilisateur
     * @param stateValuer le contenu ou la valeur de l'action
     * @param start la position du curseur
     * @param slenght prochqinne position de l'utilisateur
     */
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
