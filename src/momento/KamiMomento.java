package momento;

import observer.Observer;
import receiver.Buffer;
import receiver.Selection;

import java.util.ArrayList;
import java.util.Iterator;

public class KamiMomento {

    // --Commented out by Inspection (04/12/2017 14:24):private Buffer buffer ;




    private final CareTaker caretaker = new CareTaker();

    //  originator cree une valeur pour les statesubject,

    // creation d un momento avec ce satesubject
    // recuperation du momento du sujet
    private final Originator originator = new Originator();

    private final ArrayList<Observer> observers = new ArrayList<Observer>();




    private int sizeMomento = 0;
    private int currentSatesubject = 0;

    /**
     *
     */
    public void faire() {

        if ((sizeMomento - 1) > currentSatesubject) {
            // Increment to the current article displayed
            currentSatesubject++;

            // Get the newer article saved and display it in JTextArea

            NotifiedObserver(originator.restoreMomentoStateValue(caretaker.getMomento(currentSatesubject)), originator.restoreMomentoSelection(caretaker.getMomento(currentSatesubject)));


            // mise ajour de lecran
            //  theArticle.setText(state);

            // Make undo clickable
            //   undoBut.setEnabled(true);
            //   NotifiedObserver();
        }


    }

    /**
     * Defaire
     */
    public void defaire(){
        if(currentSatesubject >= 1){
            // Decrement to the current article displayed
            currentSatesubject--;
            // Get the older article saved and display it in JTextArea

            NotifiedObserver(originator.restoreMomentoStateValue(caretaker.getMomento(currentSatesubject)),originator.restoreMomentoSelection(caretaker.getMomento(currentSatesubject)));
           // theArticle.setText(textBoxString);
            // Make Redo clickable
          //  redoBut.setEnabled(true);
          //  NotifiedObserver();


        }

    }

    /**
     *  Enregistr un etet momento
     * @param buffer
     */
    public void saveMomento(Buffer buffer){


        if (currentSatesubject < sizeMomento){

            buffer.initBuffer(originator.restoreMomentoStateValue(caretaker.getMomento(currentSatesubject)));
            sizeMomento = currentSatesubject ;



        }
        originator.setSubject(buffer.getTexte(),buffer.getSelectStart(),buffer.getSelectLength());
        // Add new article to the ArrayList
        caretaker.addMomento( originator.storeMomento() );
        // saveFiles monitors how many articles are saved
        // currentArticle monitors the current article displayed
        sizeMomento++;
        currentSatesubject++;
   /*     System.out.println("Save momento " + sizeMomento);
        System.out.println("cure momento " + currentSatesubject);
        System.out.println("cure momento value = " + buffer.getTexte());*/
        // Make undo clickable
       // undoBut.setEnabled(true);

    }

    /**
     * Ajoute un observer
     * @param observers
     */
    public void addObserver(Observer observers) {
        this.observers.add(observers);
    }

    /**
     *  Notifie les Observer
     *
     * @param valeur
     * @param contenue
     */
    private void NotifiedObserver(String valeur, Selection contenue){

  //      System.out.println("cure momento " + currentSatesubject);

        Selection sel = new Selection();
        sel.setStart(0);sel.setLength(0);
        for (Iterator<Observer> it = observers.iterator(); it.hasNext(); ) {
            Observer observer = it.next();
            observer.getNotifield("",sel);
            observer.getNotifield(valeur,contenue);

        }
    }
}
