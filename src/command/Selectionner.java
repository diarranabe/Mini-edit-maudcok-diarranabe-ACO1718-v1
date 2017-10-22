package command;

import invoker.IHM;
import receiver.Buffer;

public class Selectionner extends Command {

	public Selectionner(Buffer buffer, IHM ihm) {
		this.buffer = buffer;
		this.ihm = ihm;
	}

	@Override
	public void execute() {
		int d = ihm.getDebutSelection();
		int l = ihm.getSelectionLength();
		buffer.setSelection(d, l);

		if (VERBOSE) {
			System.out.println("sélection: " + buffer.getSelection() + " (" + d
					+ ", " + l + ")");
		}
	}

}
