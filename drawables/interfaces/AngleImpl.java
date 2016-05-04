package drawables.interfaces;

import drawables.Line;
import util.annotations.Tags;

@Tags({"Angle"})
public interface AngleImpl extends MultiShapesImpl{
	public Line getLeftLine();

	public Line getRightLine();
}
