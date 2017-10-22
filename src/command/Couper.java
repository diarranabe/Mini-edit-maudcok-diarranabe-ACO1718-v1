
package command;

import receiver.Buffer;


public class Couper extends Command {

	public Couper(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void execute() {
		buffer.couper();
	}

}
