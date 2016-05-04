package interfaces;

import drawables.Avatar;
import util.annotations.Tags;

public interface AnimatorImpl {
	@Tags({"animateAvatar"})
	public void walkingAnimation(Avatar a, int animationPauseTime, int amountX, int amountY);
}
