package command;

import momento.KamiMomento;

public class faire extends CommandM {
    /**
     *
     * @param kamiMomento l'instance de notre objet Momento
     */
    public faire(KamiMomento kamiMomento) {
        this.kamiMomento = kamiMomento;

    }


    @Override
    public void execute() {

        this.kamiMomento.faire();
    }

}