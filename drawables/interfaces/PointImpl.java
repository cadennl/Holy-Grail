package drawables.interfaces;

import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags({"Locatable"})
public interface PointImpl extends PropertyListenerRegisterer{
	public int getX();
	public void setX(int x);
	public int getY();
	public void setY(int y);
	@Tags({"move"})
	public void move(int x, int y);
}
