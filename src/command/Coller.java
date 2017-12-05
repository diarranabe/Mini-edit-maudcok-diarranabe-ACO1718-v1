

package command;

import receiver.Buffer;

/**
 *  Concrete command Coller
 */
public class Coller extends Command {
	/**
	 *
	 * @param buffer l'instance de notre objet Buffer
	 */
	public Coller(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void execute() {
		buffer.coller();
	}

}
