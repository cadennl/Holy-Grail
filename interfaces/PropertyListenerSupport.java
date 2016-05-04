package interfaces;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface PropertyListenerSupport {
	public int size();	

	boolean isFull();

	public void addElement(PropertyChangeListener l);

	public void notifyAllListeners(PropertyChangeEvent event);
}
