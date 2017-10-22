package command;

import receiver.Buffer;


public class Supprimer extends Command {

	public Supprimer(Buffer buf) {
		buffer = buf;
	}

	@Override
	public void execute() {
		buffer.supprimer();
	}

}
