package command;


import momento.KamiMomento;

public class defaire extends CommandM {
    /**
     *
     * @param kamiMomento l'instance de notre objet Momento
     */
    public defaire(KamiMomento kamiMomento) {
        this.kamiMomento = kamiMomento;

    }

    @Override
    public void execute() {
        this.kamiMomento.defaire();
    }

}