package command;


import invoker.IHM;
import momento.KamiMomento;
import receiver.Buffer;

public class defaire extends CommandM {
    /**
     *
     * @param kamiMomento
     */
    public defaire(KamiMomento kamiMomento) {
        this.kamiMomento = kamiMomento;

    }

    @Override
    public void execute() {
        this.kamiMomento.defaire();
    }

}