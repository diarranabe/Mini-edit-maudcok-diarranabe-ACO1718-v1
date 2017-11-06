package momento;

import observer.Observer;
import receiver.Buffer;
import receiver.Selection;

import java.util.ArrayList;
import java.util.Iterator;

public class KamiMomento {

    private Buffer buffer ;




    CareTaker caretaker = new CareTaker();

    //  originator cree une valeur pour les statesubject,

    // creation d un momento avec ce satesubject
    // recuperation du momento du sujet
    Originator originator = new Originator();

    ArrayList<Observer> observers = new ArrayList<Observer>();




    int sizeMomento = 0, currentSatesubject = 0;


    public void faire() {

        if ((sizeMomento - 1) > currentSatesubject) {
            // Increment to the current article displayed
            currentSatesubject++;

            // Get the newer article saved and display it in JTextArea

            NotifiedObserver(originator.restoreMomentoStateValue(caretaker.getMomento(currentSatesubject)),originator.restoreMomentoSelection(caretaker.getMomento(currentSatesubject)));


            // mise ajour de lecran
          //  theArticle.setText(state);

            // Make undo clickable
         //   undoBut.setEnabled(true);
         //   NotifiedObserver();

        } else {
            // Don't allow user to click Redo
         //   redoBut.setEnabled(false);

        }


    }

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

        } else {

            // Don't allow user to click Undo
           // undoBut.setEnabled(false);

        }

    }

    public void saveMomento(Buffer buffer){

        System.out.println("Buffer momento " + buffer.getTexte());
        System.out.println("Selection start " + buffer.getSelectStart());
        System.out.println("Selection lenght " + buffer.getSelectLength());

        /*
        if cure different of size restart writing on cure position
         */
        if (currentSatesubject < sizeMomento){
            buffer.setSelection(0,buffer.getTexte().length());
            buffer.supprimer();


        }
        originator.setSubject(buffer.getTexte(),buffer.getSelectStart(),buffer.getSelectLength());
        // Add new article to the ArrayList
        caretaker.addMomento( originator.storeMomento() );
        // saveFiles monitors how many articles are saved
        // currentArticle monitors the current article displayed
        sizeMomento++;
        currentSatesubject++;
        System.out.println("Save momento " + sizeMomento);
        System.out.println("cure momento " + currentSatesubject);
        System.out.println("cure momento value = " + buffer.getTexte());
        // Make undo clickable
       // undoBut.setEnabled(true);

    }

    public void addObserver(Observer observers) {
        this.observers.add(observers);
    }

    public void NotifiedObserver(String s, Selection ss){

        System.out.println("cure momento " + currentSatesubject);

        Selection sel = new Selection();
        sel.setStart(0);sel.setLength(0);
        for (Iterator<Observer> it = observers.iterator(); it.hasNext(); ) {
            Observer observer = it.next();
            observer.getNotifield("",sel);
            observer.getNotifield(s,ss);

        }
    }
}
