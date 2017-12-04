
package receiver;

import java.util.ArrayList;
import java.util.Iterator;

import macro.KamiMacro;
import momento.KamiMomento;
import observer.Observer;
import observer.Subject;


public class Buffer extends Subject { // Il est observé

    private String texte;
    private Selection selection;
    private PressePapiers pressePapiers;
    private static KamiMomento kamiMomento;
    private static KamiMacro kamiMacro;

    public Buffer() {
        texte = "";
        selection = new Selection();
        pressePapiers = new PressePapiers();
        observers = new ArrayList<Observer>();
    }

    public void initBuffer(String s){
        texte = s;
        setSelection(0,0);
    }


    public void taper(char type) {
        String clipboard = pressePapiers.getContent();
        int start = selection.getStart();
        if (selection.getLength() == 0) {
            texte = texte.substring(0, start) + type + texte.substring(start);
            selection.setStart(start + 1);
        } else {
            texte = texte.substring(0, start) + type + texte.substring(start + selection.getLength());
            selection.setStart(start + 1);
            selection.setLength(0);
        }
        kamiMomento.saveMomento(this);
        System.out.println("=> "+ kamiMacro.getStatue());
        if (kamiMacro.getStatue() == 2 ){
            kamiMacro.enregistrer("taper" , type, selection );

        }
        notifyMyObservers();
    }

    public String getTexte() {
        return texte;
    }

    public void copier() {

        if (selection.getLength() > 0) {
            pressePapiers.setContent(getSelection());
            if (kamiMacro.getStatue() == 2 ){
                kamiMacro.enregistrer("copier" , ' ', selection );
            }
        }
    }

    public void couper()  {
        if (selection.getLength() > 0) {
            pressePapiers.setContent(getSelection());
            int selStart = selection.getStart();
            texte = texte.substring(0, selStart) + texte.substring(selStart + selection.getLength());
            selection.setLength(0);

            if (kamiMacro.getStatue() == 2 ){
                kamiMacro.enregistrer("couper" , ' ', selection );
            }
            kamiMomento.saveMomento(this);

            notifyMyObservers();
        }
    }


    public void coller() {
        int selStart = selection.getStart();
        String clipboard = pressePapiers.getContent();
        if (!clipboard.equals(""))
        if (selection.getLength() == 0) {
            texte = texte.substring(0, selStart) + clipboard + texte.substring(selStart);
            selection.setStart(selStart + clipboard.length());
        } else {
            texte = texte.substring(0, selStart) + clipboard + texte.substring(selStart + selection.getLength());
            selection.setStart(selStart + clipboard.length());
            selection.setLength(0);
        }
        kamiMomento.saveMomento(this);
        if (kamiMacro.getStatue() == 2 ){
            kamiMacro.enregistrer("coller" , ' ', selection );
        }
        notifyMyObservers();
    }

    public void supprimer() {
        int start = selection.getStart();
        if (selection.getLength() > 0) {
            texte = texte.substring(0, start)
                    + texte.substring(start + selection.getLength());
            selection.setLength(0);
        } else if (start > 0) {
            texte = texte.substring(0, start - 1) + texte.substring(start);
            selection.setStart(start - 1);
        }
        if (kamiMacro.getStatue() == 2 ){
            kamiMacro.enregistrer("supprimer" , ' ', selection );
        }
        kamiMomento.saveMomento(this);
        notifyMyObservers();
    }


    public String getSelection() {
        int start = selection.getStart();
        int length = selection.getLength();
        if (length > 0) {
            return texte.substring(start, start + length);
        } else {
            return "";
        }
    }

    public int getSelectStart() {
        return selection.getStart();
    }

    public int getSelectLength() {
        return selection.getLength();
    }

    @Override
    public void notifyMyObservers() {

        for (Iterator<Observer> it = observers.iterator(); it.hasNext(); ) {
            Observer observer = it.next();
            observer.getNotifield();

        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
        kamiMomento.addObserver(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void setSelection(int start, int length) {
        selection.setStart(start);
        selection.setLength(length);
    }

    public void conectMomento(KamiMomento kamiMomento) {
        this.kamiMomento = kamiMomento;

    }
    public void conectMomento(KamiMacro kamiMacro) {
        this.kamiMacro = kamiMacro;

    }
}
