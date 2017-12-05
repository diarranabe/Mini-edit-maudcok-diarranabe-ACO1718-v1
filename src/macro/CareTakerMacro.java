package macro;

import java.util.ArrayList;

/**
 *  CareTakerMacro gestion des sauvegardes de momento
 */
class CareTakerMacro {

    private final ArrayList<MomentoMacro> momentos = new ArrayList<>() ;

    /**
     *
     * @param m Ajoute un MomentoMacro a la liste MomentoMacros
     */
    public void addMomentoMacro(MomentoMacro m){
        momentos.add(m);
    }
    /*
    Recupere le momento a l'index  i
     */

    /**
     *
     * @param i index
     * @return Recupere le momento a l'index  i
     */
    public MomentoMacro getMomentoMacro(int i){
        return momentos.get(i);
    }

    /**
     * Vide la liste des ;o;ento enregistrer
     */
    public void eraseFuture(){
      momentos.clear();
    }

}
