
package client;

import java.util.HashMap;
import observer.IhmObserver;
import receiver.Buffer;
import command.*;

public class Client {
	private static final int ZONE_TEXTE_ROWS = 40;
	private static final int ZONE_TEXTE_COLS = 70;

	private static Buffer buffer;
	private static IhmObserver ihm;
	private static HashMap<String, Command> commmands;

	public static void main(String[] args) throws Exception {

		buffer = new Buffer();
		ihm = new IhmObserver(buffer);

		commmands = new HashMap<String, Command>();
		commmands.put("couper", new Couper(buffer));
		commmands.put("copier", new Copier(buffer));
		commmands.put("coller", new Coller(buffer));
		commmands.put("selectionner", new Selectionner(buffer, ihm));
		commmands.put("taper", new Taper(buffer, ihm));
		commmands.put("supprimer", new Supprimer(buffer));
		ihm.setCommands(commmands);

		// mise en place de l'observer
		buffer.addObserver(ihm);

		// finalisation de l'ihm
		ihm.addTextArea(ZONE_TEXTE_ROWS, ZONE_TEXTE_COLS);
		ihm.initButtons();
		ihm.show();
	}

}
