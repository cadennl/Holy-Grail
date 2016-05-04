package drawables.interfaces;

import drawables.ParallelLines;

public interface RectangleImpl extends ShapeImpl {
	public ParallelLines getFirstParallel();
	public ParallelLines getSecondParallel();
}
