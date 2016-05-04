package drawables;

import drawables.generics.GenericPoint;
import drawables.interfaces.AngleImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Angle"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"x", "y", "leftLine", "rightLine"}) 
@EditablePropertyNames({"x", "y"})
public class Angle extends GenericPoint implements AngleImpl {	
	private Line leftLine, rightLine;
	
	public Angle() {
		super(25, 25);
	}
	
	public Angle(int x, int y, int width, int height) {
		super(x, y);
		
		this.leftLine = new Line(x, y, width, height);
		this.rightLine = new Line(x, y, -width, height);
	}
	
	public Angle(Line leftLine, Line rightLine) {
		super(leftLine.getX(), leftLine.getY());
		
		this.leftLine = leftLine;
		this.rightLine = rightLine;
	}

	public Line getLeftLine() {
		return leftLine;
	}

	public Line getRightLine() {
		return rightLine;
	}

	@Override
	public void move(int x, int y) {
		this.leftLine.move(x, y);
		this.rightLine.move(x, y);
	}
}
