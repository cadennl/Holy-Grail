package drawables;

import java.beans.PropertyChangeEvent;

import drawables.generics.GenericShape;
import drawables.interfaces.StringShapeImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.LABEL_PATTERN) 
@PropertyNames({"x", "y", "width", "height", "text"}) 
@EditablePropertyNames({"x", "y",  "width", "height", "text"})
public class StringShape extends GenericShape implements StringShapeImpl{
	String text;

	public StringShape(int x, int y, String text) {
		super(x, y, 100, 200);
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		String oldText = this.text;
		this.text = text;
		
		if(propertyListenerSupport != null) {
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "text", oldText, this.text));
		}
	}
}
