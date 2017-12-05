
package command;

import receiver.Buffer;

public class Copier extends Command {
	/**
	 *
	 * @param buffer l'instance de notre objet Buffer
	 */
	public Copier(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void execute() {
		buffer.copier();
	}

}
