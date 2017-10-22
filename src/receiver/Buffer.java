
package receiver;

import java.util.ArrayList;
import java.util.Iterator;

import observer.Observer;
import observer.Subject;

/**
 * Gère les modifications du texte et du press-papiers.
 */
public class Buffer extends Subject {

	private String texte;
	private PressePapiers pressePapiers;
	private Selection selection;

	public Buffer() {
		observers = new ArrayList<Observer>();
		texte = "";
		pressePapiers = new PressePapiers();
		selection = new Selection();
	}

	public String getTexte() {
		return texte;
	}

	/**
	 * Copie le texte sélectionné dans le presse-papiers en remplaçant l'ancien
	 * et supprime le texte sélectionné du buffer ;
	 */
	public void couper() {
		if (selection.getLength() > 0) {
			pressePapiers.setContent(getSelection());
			texte = texte.substring(0, selection.getStart())
					+ texte.substring(selection.getStart()
							+ selection.getLength());
			selection.setLength(0);
			notifyObservers();
		}
	}


	public void copier() {
		if (selection.getLength() > 0) {
			pressePapiers.setContent(getSelection());
		}
	}


	public void coller() {
		int i = selection.getStart();
		if (selection.getLength() == 0) {
			texte = texte.substring(0, i) + pressePapiers.getContent()
					+ texte.substring(i);
			selection.setStart(i + pressePapiers.getContent().length());
		} else {
			texte = texte.substring(0, i) + pressePapiers.getContent()
					+ texte.substring(i + selection.getLength());
			selection.setStart(i + pressePapiers.getContent().length());
			selection.setLength(0);
		}
		notifyObservers();
	}

	/**
	 * Insère le caractère tapé dans le buffer à l'emplacement du curseur, ou à
	 * la place du texte sélectionné.
	 * 
	 * @param c
	 *            le caractère tapé
	 */
	public void taper(char c) {
		int i = selection.getStart();
		if (selection.getLength() == 0) {
			texte = texte.substring(0, i) + c + texte.substring(i);
			selection.setStart(i + 1);
		} else {
			texte = texte.substring(0, i) + c
					+ texte.substring(i + selection.getLength());
			selection.setStart(i + 1);
			selection.setLength(0);
		}
		notifyObservers();
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
		notifyObservers();
	}

	/**
	 * Renvoie la sous-chaîne du texte actuellement sélectionnée.
	 * 
	 * @return le texte sélectionné
	 */
	public String getSelection() {
		int i = selection.getStart(), l = selection.getLength();
		if (selection.getLength() > 0) {
			return texte.substring(i, i + l);
		} else {
			return "";
		}
	}
	
	public int getSelectionDebut() {
		return selection.getStart();
	}
	
	public int getSelectionLongueur() {
		return selection.getLength();
	}

	@Override
	public void notifyObservers() {
		for (Iterator<Observer> it = observers.iterator(); it.hasNext();) {
			Observer o = it.next();
			o.notifyMe();
		}
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);

	}

	@Override
	public void unregisterObserver(Observer o) {
		observers.remove(o);
	}

	public void setSelection(int debut, int longueur) {
		selection.setStart(debut);
		selection.setLength(longueur);
	}
}
