package command;

import macro.KamiMacro;
/**
 *  Concrete command StopRecordMacro pour arreter l'enregistrment de la nacro
 */
public class StopRecordMacro extends CommandMacro {

    public StopRecordMacro(KamiMacro kamiMacro) {
        this.kamiMacro = kamiMacro ;
    }

    @Override
    public void execute() {

        this.kamiMacro.StopRecord();
    }

}
