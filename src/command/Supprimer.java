package command;

import receiver.Buffer;

/**
 * Command pour supprimmer un caractere du buffer
 */
public class Supprimer extends Command {

	public Supprimer(Buffer buf) {
		buffer = buf;
	}

	@Override
	public void execute() {
		buffer.supprimer();
	}

}
