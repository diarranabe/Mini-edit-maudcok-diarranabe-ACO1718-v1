package macro;

import observer.Observer;
import receiver.Buffer;
import receiver.Selection;

import java.util.ArrayList;
import java.util.Iterator;

public class KamiMacro {

    int TimeZero;
    int ss ;

    private Buffer buffer;
    /**
     * Variable 2-enregiste
     * 0-stop
     * 1-play
     */
    private int statue = 0;


    CareTakerMacro caretaker = new CareTakerMacro();

    //  originator cree une valeur pour les statesubject,

    // creation d un momento avec ce satesubject
    // recuperation du momento du sujet
    OriginatorMacro originator = new OriginatorMacro();

    ArrayList<Observer> observers = new ArrayList<Observer>();
    private int siezemacro = 0;


    /**
     * enregistrement des comande
     *
     * @param actionCmd
     * @param stateValuer
     * @param select
     */
    public void enregistrer(String actionCmd, char stateValuer, Selection select) {
        int timeswap = select.getStart() - TimeZero;
        TimeZero = buffer.getSelectStart();

        System.out.println(" macro start = " + select.getStart() +" zeropos = "+ TimeZero +" Swap = " +timeswap+ " Cmd = " +actionCmd );


        originator.setAction(actionCmd, stateValuer, timeswap, select.getLength());
        // Add new article to the ArrayList
        System.out.println("add cnd => " + actionCmd);
        caretaker.addMomentoMacro(originator.storeMomento());
        siezemacro++;

    }

    /**
     * Jouer la Macro enregistrer
     */
    public void jouer() {
        if (buffer!= null){
        statue = 1;
        ss = buffer.getSelectStart();
        System.out.println("ss = "+ss);
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < siezemacro; i++) {

                    MomentoMacro momentoMacro = caretaker.getMomentoMacro(i);
                    int lenght = originator.restoreMacroLenghtn(momentoMacro);
                    int timeswap = originator.restoreMacroSart(momentoMacro);
                   // if (timeswap<0)timeswap-- ;
                    System.out.println("timeSwap => " + timeswap);
                    char stape = originator.restoreMacroStateValue(momentoMacro);
 System.out.println(" zeropos = "+ ss +" Swap = " +timeswap+ " Cmd = " +originator.restoreMacroAction(momentoMacro) + " Value = -" + stape+"-");
                    switch (originator.restoreMacroAction(momentoMacro)) {
                        case "copier":
                            buffer.setSelection(ss + timeswap, lenght);
                            buffer.copier();
                            break;
                        case "couper":
                            buffer.setSelection(ss + timeswap, lenght);
                            if (timeswap< 0)
                            ss+=lenght ;
                            buffer.couper();
                            break;
                        case "coller":
                            buffer.setSelection(ss + timeswap, lenght);
                            ss+=lenght ;
                            buffer.coller();
                            break;
                        case "taper":
                            if (timeswap>0){
                                buffer.taper(stape);
                            }else {
                                buffer.setSelection(ss + timeswap, lenght);
                                ss+=timeswap ;
                                buffer.taper(stape);
                            }

                            break;
                    }
                    try {
                        this.sleep(750);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        thread.run();}
    }

    /**
     *
     * @return Etat de la machine a macros
     */
    public int getStatue() {
        return statue;
    }

    public void Record(Buffer buffer) {
        // vider le momento macro

        this.buffer = buffer;
        TimeZero = buffer.getSelectStart();
        statue = 2;
        siezemacro=0;
        caretaker.eraseFuture();
    }

    /**
     *  Met le status de la machine macro a 0
     */
    public void StopRecord() {
        statue = 0;
    }
}
