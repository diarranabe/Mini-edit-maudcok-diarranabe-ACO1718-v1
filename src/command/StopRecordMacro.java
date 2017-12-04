package command;

import macro.KamiMacro;

public class StopRecordMacro extends CommandMacro {
    /**
     *
     * @param kamiMacro
     */
    public StopRecordMacro(KamiMacro kamiMacro) {
        this.kamiMacro = kamiMacro ;
    }

    @Override
    public void execute() {

        this.kamiMacro.StopRecord();
    }

}
