package command;

import macro.KamiMacro;
/**
 *  Concrete command PlayMacro pour jouer l'enregistrment de la nacro
 */
public class PlayMacro extends CommandMacro {
    /**
     *
     * @param kamiMacro l'instance de notre objet Macro
     */
    public PlayMacro(KamiMacro kamiMacro) {
        this.kamiMacro = kamiMacro;
    }

    @Override
    public void execute() {

        this.kamiMacro.jouer();
    }
}
