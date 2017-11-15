package momento;


import java.util.ArrayList;

public class CareTaker {

    /**
     * Liste de Momento
     */
    private  ArrayList<Momento> momentos = new ArrayList<Momento>() ;

    /**
     * Ajoute un Momento a la liste Momento
     * @param m
     */
    public void addMomento(Momento m){
        momentos.add(m);
    }

    /**
     * Recupere le momento à l'index  i
     * @param i
     * @return
     */
    public Momento getMomento(int i){
        return momentos.get(i);
    }
}
