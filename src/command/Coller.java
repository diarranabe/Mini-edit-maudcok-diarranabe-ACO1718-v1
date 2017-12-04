

package command;

import receiver.Buffer;

public class Coller extends Command {
	/**
	 *
	 * @param buffer
	 */
	public Coller(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void execute() {
		buffer.coller();
	}

}
