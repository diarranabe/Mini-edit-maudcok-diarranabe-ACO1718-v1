
package command;

import receiver.Buffer;

public class Copier extends Command {

	public Copier(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void execute() {
		buffer.copier();
	}

}
