package client;

import command.*;
import macro.KamiMacro;
import observer.IhmObserver;
import receiver.Buffer;

import java.util.HashMap;

/**
 *  Classe principale du projet
 *
 */
class Client {
	private static final int ZONE_TEXTE_ROWS = 40;
	private static final int ZONE_TEXTE_COLS = 70;

	/**
	 *  Main class
	 * @param args  string
	 * @throws Exception IHM exception
	 */
	public static void main(String[] args) throws Exception {

		Buffer buffer = new Buffer();
		IhmObserver ihm = new IhmObserver(buffer);

		/*
		Momento
		 */
		KamiMacro kamiMacro = new KamiMacro();

		HashMap<String, Command> commmands = new HashMap<>();
		commmands.put("couper", new Couper(buffer));
		commmands.put("copier", new Copier(buffer));
		commmands.put("coller", new Coller(buffer));
		commmands.put("selectionner", new Selectionner(buffer, ihm));
		commmands.put("taper", new Taper(buffer, ihm));
		commmands.put("supprimer", new Supprimer(buffer));
		ihm.setCommands(commmands);


		HashMap<String, CommandMacro> commmandMacro = new HashMap<>();
		commmandMacro.put("play", new PlayMacro(kamiMacro));
		commmandMacro.put("record", new RecordMacro(kamiMacro, buffer));
		commmandMacro.put("stop", new StopRecordMacro(kamiMacro));
		ihm.setCommandMacro(commmandMacro);


		buffer.conectMomento(kamiMacro);

		// mise en place de l'observer
		buffer.addObserver(ihm);

		// finalisation de l'ihm
		ihm.initButtons();
		ihm.addTextArea(ZONE_TEXTE_ROWS, ZONE_TEXTE_COLS);
		ihm.show();
	}

}
