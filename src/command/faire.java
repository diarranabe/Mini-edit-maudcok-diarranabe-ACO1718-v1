package command;

import momento.KamiMomento;
import receiver.Buffer;

public class faire extends CommandM {
    /**
     *
     * @param kamiMomento
     */
    public faire(KamiMomento kamiMomento) {
        this.kamiMomento = kamiMomento;

    }


    @Override
    public void execute() {

        this.kamiMomento.faire();
    }

}