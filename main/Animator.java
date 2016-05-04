package main;

import drawables.Avatar;
import interfaces.AnimatorImpl;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"Animator"})
public class Animator implements AnimatorImpl{
	
	@Tags({"animateAvatar"})
	public synchronized void walkingAnimation(Avatar a, int animationPauseTime, int amountX, int amountY) {
		int originalWidth = a.getLegs().getLeftLine().getWidth();
		int xStep = amountX < 0 ? -1 : 1;
		int yStep = amountY < 0 ? -1 : 1;
		
		while(amountX > 0 || amountY > 0) {
			ThreadSupport.sleep(animationPauseTime);
			if(a.getLegs().getLeftLine().getWidth() == 0)
				setLegWidth(a, originalWidth);
			else
				setLegWidth(a, 0);
			a.move(xStep, yStep);
			if(amountX > 0)
				amountX--;
			if(amountY > 0)
				amountY--;
		}
	}
	
	private void setLegWidth(Avatar a, int width) {
		a.getLegs().getLeftLine().setWidth(width);
		a.getLegs().getRightLine().setWidth(-width);
	}
}
