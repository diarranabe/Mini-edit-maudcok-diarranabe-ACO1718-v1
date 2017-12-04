
package client;

import java.util.HashMap;

import macro.KamiMacro;
import momento.KamiMomento;
import observer.IhmObserver;
import receiver.Buffer;
import command.*;

class Client {
	private static final int ZONE_TEXTE_ROWS = 40;
	private static final int ZONE_TEXTE_COLS = 70;

	private static Buffer buffer;
	private static KamiMomento kamiMomento;
	private static KamiMacro kamiMacro;
	private static IhmObserver ihm;
	private static HashMap<String, Command> commmands;
	private static HashMap<String, CommandM> commmandMs;
	private static HashMap<String, CommandMacro> commmandMacro;

	public static void main(String[] args) throws Exception {

		buffer = new Buffer();
		ihm = new IhmObserver(buffer);

		/*
		Momento
		 */
		kamiMomento = new KamiMomento() ;
		kamiMacro = new KamiMacro() ;

		commmands = new HashMap<String, Command>();
		commmands.put("couper", new Couper(buffer));
		commmands.put("copier", new Copier(buffer));
		commmands.put("coller", new Coller(buffer));
		commmands.put("selectionner", new Selectionner(buffer, ihm));
		commmands.put("taper", new Taper(buffer, ihm));
		commmands.put("supprimer", new Supprimer(buffer));
		ihm.setCommands(commmands);

		commmandMs = new HashMap<String, CommandM>();
		commmandMs.put("faire", new faire(kamiMomento));
		commmandMs.put("defaire", new defaire(kamiMomento));
		ihm.setCommandMs(commmandMs);

		commmandMacro = new HashMap<String, CommandMacro>();
		commmandMacro.put("play", new PlayMacro(kamiMacro));
		commmandMacro.put("record", new RecordMacro(kamiMacro,buffer));
		commmandMacro.put("stop", new StopRecordMacro(kamiMacro));
		ihm.setCommandMacro(commmandMacro);

		buffer.conectMomento(kamiMomento);
		buffer.conectMomento(kamiMacro);

		// mise en place de l'observer
		buffer.addObserver(ihm);

		// finalisation de l'ihm
		ihm.initButtons();
		ihm.addTextArea(ZONE_TEXTE_ROWS, ZONE_TEXTE_COLS);
		ihm.show();
	}

}
