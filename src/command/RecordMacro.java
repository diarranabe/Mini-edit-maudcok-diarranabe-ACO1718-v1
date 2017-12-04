package command;

import macro.KamiMacro;
import receiver.Buffer;

public class RecordMacro extends CommandMacro {
    /**
     *
     * @param kamiMacro
     * @param buffer
     */
    public RecordMacro(KamiMacro kamiMacro, Buffer buffer) {
        this.buffer = buffer;
        this.kamiMacro = kamiMacro ;
    }

    @Override
    public void execute() {

        this.kamiMacro.Record(this.buffer);
    }

}
