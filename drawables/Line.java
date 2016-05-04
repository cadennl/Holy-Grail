package drawables;

import drawables.generics.GenericShape;
import drawables.interfaces.ShapeImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"String"})
@StructurePattern(StructurePatternNames.LINE_PATTERN) 
@PropertyNames({"x", "y", "width", "height"}) 
@EditablePropertyNames({"x", "y", "width", "height"}) 
public class Line extends GenericShape implements ShapeImpl {

	public Line(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
}
