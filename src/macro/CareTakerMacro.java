package macro;

import java.util.ArrayList;

class CareTakerMacro {

    private final ArrayList<MomentoMacro> momentos = new ArrayList<MomentoMacro>() ;

    /*
    Ajoute un MomentoMacro a la liste MomentoMacros
     */
    public void addMomentoMacro(MomentoMacro m){
        momentos.add(m);
    }
    /*
    Recupere le momento a l'index  i
     */
    public MomentoMacro getMomentoMacro(int i){
        return momentos.get(i);
    }

    public void eraseFuture(){
      momentos.clear();
    }

}
