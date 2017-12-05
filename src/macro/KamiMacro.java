package macro;

import receiver.Buffer;
import receiver.Selection;

public class KamiMacro {

    private int TimeZero;
    private int ss ;

    private Buffer buffer;
    /**
     * Variable 2-enregiste
     * 0-stop
     * 1-play
     */
    private int statue = 0;


    private final CareTakerMacro caretaker = new CareTakerMacro();

    //  originator cree une valeur pour les statesubject,

    // creation d un momento avec ce satesubject
    // recuperation du momento du sujet
    private final OriginatorMacro originator = new OriginatorMacro();

    // --Commented out by Inspection (04/12/2017 14:24):ArrayList<Observer> observers = new ArrayList<Observer>();
    private int siezemacro = 0;


    /**
     * enregistrement des comande
     *
     * @param actionCmd  Le rype de commende effectuer par l'utilisateur
     * @param stateValuer la valeur de cette commende
     * @param select la selection faite par l'utilisateur
     */
    public void enregistrer(String actionCmd, char stateValuer, Selection select) {
        int timeswap = select.getStart() - TimeZero;
        System.out.println("Lenght -> "+ select.getLength()+" curs pos = " + select.getStart() +" zeropos = "+ TimeZero +" Swap = " +timeswap+ " Cmd = " +actionCmd );
      //  TimeZero = buffer.getSelectStart();
        TimeZero = select.getStart();

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

                    char stape = originator.restoreMacroStateValue(momentoMacro);
 //System.out.println(" zeropos = "+ ss +" Swap = " +timeswap+" go-to "+ auxx+ " Cmd = " +originator.restoreMacroAction(momentoMacro) + " Value = -" + stape+"-");
                    switch (originator.restoreMacroAction(momentoMacro)) {
                        case "copier":

                            buffer.setSelection(ss + timeswap, lenght);
                            ss+=timeswap ;
                            buffer.copier();
                            break;
                        case "couper":
                            System.out.println("lenght  -> " + lenght);
                            buffer.setSelection(ss + timeswap, lenght);
                            ss+=timeswap ;
                            buffer.couper();
                            break;
                        case "coller":

                            buffer.setSelection(ss , lenght);
                            ss+=lenght + timeswap ;
                            buffer.coller();
                            break;
                        case "taper":
                            if (timeswap>=0){
                                buffer.taper(stape);
                            }else {
                                buffer.setSelection(ss + timeswap, lenght);
                                ss+=timeswap ;
                                buffer.taper(stape);
                            }

                            break;
                    }
                    try {
                        sleep(500);
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

        System.out.println(" Debut de l'enregistrment ");
    }

    /**
     *  Met le status de la machine macro a 0
     */
    public void StopRecord() {
        statue = 0;
        System.out.println(" Fin de l'enregistrment ");
    }
}
