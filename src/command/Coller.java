

package command;

import receiver.Buffer;

public class Coller extends Command {

	public Coller(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void execute() {
		buffer.coller();
	}

}
