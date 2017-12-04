package momento;


import java.util.ArrayList;

class CareTaker {

    private final ArrayList<Momento> momentos = new ArrayList<Momento>() ;

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

// --Commented out by Inspection START (04/12/2017 14:24):
//    public void eraseFuture(int i){
//        int a;
//        a= momentos.size() - i +1;
//
//        for (int e=0 ; e < a ; e++){
//            momentos.remove(i+1) ;
//        }
//    }
// --Commented out by Inspection STOP (04/12/2017 14:24)

}
