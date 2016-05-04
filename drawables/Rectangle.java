package drawables;

import drawables.generics.GenericShape;
import drawables.interfaces.RectangleImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"x", "y", "width", "height", "firstParallel", "secondParallel"}) 
@EditablePropertyNames({"x", "y", "width", "height"})
public class Rectangle extends GenericShape implements RectangleImpl {
	private ParallelLines firstParallel, secondParallel;
	
	public Rectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		this.firstParallel = new ParallelLines(x, y, 0, height, true, width);
		this.secondParallel = new ParallelLines(x, y, width, 0, false, height);
	}

	public ParallelLines getFirstParallel() {
		return firstParallel;
	}

	public ParallelLines getSecondParallel() {
		return secondParallel;
	}
	
	@Override
	public void move(int x, int y) {
		this.firstParallel.move(x, y);
		this.secondParallel.move(x, y);
	}
}
