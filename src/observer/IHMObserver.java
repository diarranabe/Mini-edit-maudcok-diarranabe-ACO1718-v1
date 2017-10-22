
package observer;

import invoker.IHM;
import receiver.Buffer;

public class IHMObserver extends IHM implements Observer {

	protected Subject subject;
	
	public IHMObserver(Subject sub) {
		subject = sub;
	}

	@Override
	public void notifyIhm() {
		Buffer b = (Buffer) subject;
		textArea.refresh(b.getTexte(), b.getSelectionDebut(), b.getSelectionLongueur());
	}

}
