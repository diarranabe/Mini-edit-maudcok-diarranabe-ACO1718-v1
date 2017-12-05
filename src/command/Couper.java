
package command;

import receiver.Buffer;

/**
 *  Concrete command Couper
 */
public class Couper extends Command {

	public Couper(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void execute() {
		buffer.couper();
	}

}
