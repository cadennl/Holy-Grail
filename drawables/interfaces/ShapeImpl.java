package drawables.interfaces;

import util.annotations.Tags;

@Tags({"Bounded Shape"})
public interface ShapeImpl extends PointImpl{
	public int getWidth();
	public void setWidth(int width);
	public int getHeight();
	public void setHeight(int height);
}
