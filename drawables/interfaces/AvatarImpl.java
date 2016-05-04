package drawables.interfaces;

import drawables.Angle;
import drawables.Head;
import drawables.Line;
import drawables.StringShape;
import util.annotations.Tags;

@Tags({"Avatar"})
public interface AvatarImpl extends MultiShapesImpl {
	public StringShape getUtterance();
	public String getKnight();
	public int getHeight();
	public Head getHead();

	public Angle getArms();

	public Angle getLegs();

	public Line getBody();
	
	public int getOriginalX();

	public int getOriginalY();
}
