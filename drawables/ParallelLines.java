package drawables;

import drawables.generics.GenericPoint;
import drawables.interfaces.ParallelLinesImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"x", "y", "firstLine", "secondLine"}) 
@EditablePropertyNames({"x", "y"})
public class ParallelLines extends GenericPoint implements ParallelLinesImpl {	
	private Line firstLine, secondLine;
	
	public ParallelLines(int x, int y, int width, int height, boolean vertical, int spacing) {
		super(x, y);
		
		this.firstLine = new Line(x, y, width, height);
				
		if(vertical) {
			x += spacing;
		} else {
			y += spacing;
		}
		
		this.secondLine = new Line(x, y, width, height);
	}

	public Line getFirstLine() {
		return firstLine;
	}

	public Line getSecondLine() {
		return secondLine;
	}
	
	@Override
	public void move(int x, int y) {
		this.firstLine.move(x, y);
		this.secondLine.move(x, y);
	}
}
