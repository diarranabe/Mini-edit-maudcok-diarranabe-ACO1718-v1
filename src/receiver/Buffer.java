
package receiver;

import java.util.ArrayList;
import java.util.Iterator;

import observer.Observer;
import observer.Subject;


public class Buffer extends Subject { // Il est observé

	private String texte;
	private Selection selection;
	private PressePapiers pressePapiers;

	public Buffer() {
		texte = "";
		selection = new Selection();
		pressePapiers = new PressePapiers();
		observers = new ArrayList<Observer>();
	}


	public void taper(char type) {
		String clipboard = pressePapiers.getContent();
		int start = selection.getStart();
		if (selection.getLength() == 0) {
			texte = texte.substring(0, start) + type + texte.substring(start);
			selection.setStart(start + 1);
		} else {
			texte = texte.substring(0, start) + type + texte.substring(start + selection.getLength());
			selection.setStart(start + 1);
			selection.setLength(0);
		}
		notifyMyObservers();
	}

	public String getTexte() {
		return texte;
	}

	public void copier() {
		if (selection.getLength() > 0) {
			pressePapiers.setContent(getSelection());
		}
	}

	public void couper() {
		if (selection.getLength() > 0) {
			pressePapiers.setContent(getSelection());
			int selStart = selection.getStart();
			texte = texte.substring(0, selStart) + texte.substring(selStart + selection.getLength());
			selection.setLength(0);
			notifyMyObservers();
		}
	}



	public void coller() {
		int selStart = selection.getStart();
		String clipboard = pressePapiers.getContent();
		if (selection.getLength() == 0) {
			texte = texte.substring(0, selStart) + clipboard + texte.substring(selStart);
			selection.setStart(selStart + clipboard.length());
		} else {
			texte = texte.substring(0, selStart) + clipboard + texte.substring(selStart + selection.getLength());
			selection.setStart(selStart + clipboard.length());
			selection.setLength(0);
		}
		notifyMyObservers();
	}

	public void supprimer() {
		int start = selection.getStart();
		if (selection.getLength() > 0) {
			texte = texte.substring(0, start)
					+ texte.substring(start + selection.getLength());
			selection.setLength(0);
		} else if (start > 0) {
			texte = texte.substring(0, start - 1) + texte.substring(start);
			selection.setStart(start - 1);
		}		
		notifyMyObservers();
	}


	public String getSelection() {
		int start = selection.getStart();
		int length = selection.getLength();
		if (length > 0) {
			return texte.substring(start, start + length);
		} else {
			return "";
		}
	}
	
	public int getSelectStart() {
		return selection.getStart();
	}
	
	public int getSelectLength() {
		return selection.getLength();
	}

	@Override
	public void notifyMyObservers() {
		for (Iterator<Observer> it = observers.iterator(); it.hasNext();) {
			Observer observer = it.next();
			observer.getNotifield();
		}
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);

	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	public void setSelection(int start, int length) {
		selection.setStart(start);
		selection.setLength(length);
	}
}
