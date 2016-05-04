package drawables.interfaces;

import drawables.Avatar;
import drawables.ParallelLines;
import drawables.Rectangle;
import util.annotations.Tags;

@Tags({"BridgeScene"})
public interface BridgeImpl extends MultiShapesImpl{
	public Avatar getArthur();

	public Avatar getLancelot();

	public Avatar getRobin();

	public Avatar getGalahad();

	public Avatar getGuard();
	
	public Rectangle getKnightArea();

	public Rectangle getGuardArea();

	public ParallelLines getGorge();

	public Rectangle getBridge();

	public boolean isOccupied();

	public boolean isKnightTurn();
	
	@Tags({"approach"})
	public void approach(Avatar a);
	
	@Tags({"passed"})
	public void passed();
	
	@Tags({"failed"})
	public void failed();
	
	@Tags({"say"})
	public void say(String utterance);
	
	public boolean preApproach(Avatar a);
	public boolean preFail();
	public boolean preSay(String utterance);
	public boolean prePass();
	
	public Avatar currentKnight(String knight);
}
