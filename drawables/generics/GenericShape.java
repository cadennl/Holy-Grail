package drawables.generics;

import java.beans.PropertyChangeEvent;

import drawables.interfaces.ShapeImpl;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"x", "y", "width", "height"}) 
@Tags({"Bounded Shape"})
public abstract class GenericShape extends GenericPoint implements ShapeImpl {
	protected int width, height;

	public GenericShape(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		int oldWidth = this.width;
		this.width = width;
		
		if(propertyListenerSupport != null) {
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "width", oldWidth, this.width));
		}
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		int oldHeight = this.height;
		this.height = height;
		
		if(propertyListenerSupport != null) {
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "height", oldHeight, this.height));
		}
	}
}
