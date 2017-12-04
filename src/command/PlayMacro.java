package command;

import macro.KamiMacro;

public class PlayMacro extends CommandMacro {

    public PlayMacro(KamiMacro kamiMacro) {
        this.kamiMacro = kamiMacro;
    }

    @Override
    public void execute() {

        this.kamiMacro.jouer();
    }
}
