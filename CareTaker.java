package momento;


import java.util.ArrayList;

public class CareTaker {

    private  ArrayList<Momento> momentos = new ArrayList<Momento>() ;

    /*
    Ajoute un Momento a la liste Momentos
     */
    public void addMomento(Momento m){
        momentos.add(m);
    }
    /*
    Recupere le momento a l'index  i
     */
    public Momento getMomento(int i){
        return momentos.get(i);
    }
}