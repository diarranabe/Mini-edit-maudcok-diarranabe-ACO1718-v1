package command;

import momento.KamiMomento;
import receiver.Buffer;

public class faire extends CommandM {

    public faire(KamiMomento kamiMomento) {
        this.kamiMomento = kamiMomento;

    }


    @Override
    public void execute() {

        this.kamiMomento.faire();
    }

}