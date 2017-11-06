
package observer;

import invoker.IHM;
import receiver.Buffer;

public class IhmObserver extends IHM implements Observer {

	protected Subject subject;
	
	public IhmObserver(Subject sub) {
		subject = sub;
	}

	@Override
	public void getNotifield() {
		Buffer buffer = (Buffer) subject;
		textArea.refresh(buffer.getTexte(), buffer.getSelectStart(), buffer.getSelectLength());
	}
}
