
package observer;

import java.util.Collection;


public abstract class Subject {
	protected Collection<Observer> observers;


	public abstract void notifyMyObservers();


	public abstract void addObserver(Observer observer);

	public abstract void removeObserver(Observer observer);

}
