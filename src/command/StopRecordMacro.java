package command;

import macro.KamiMacro;

public class StopRecordMacro extends CommandMacro {

    public StopRecordMacro(KamiMacro kamiMacro) {
        this.kamiMacro = kamiMacro ;
    }

    @Override
    public void execute() {

        this.kamiMacro.StopRecord();
    }

}
