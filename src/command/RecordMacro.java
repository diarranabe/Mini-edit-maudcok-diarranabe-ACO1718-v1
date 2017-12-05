package command;

import macro.KamiMacro;
import receiver.Buffer;

public class RecordMacro extends CommandMacro {
    /**
     *
     * @param kamiMacro l'instance de notre objet Macro
     * @param buffer l'instance de notre objet Buffer
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
