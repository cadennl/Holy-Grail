package main;

import drawables.Avatar;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"animator", "avatar", "animationPauseTime", "x", "y"})
@Tags({"AnimatingCommand"})
public class AnimatingClass implements Runnable{
	public Animator animator;
	public Avatar avatar;
	public int animationPauseTime, x, y;

	public AnimatingClass(Animator animator, Avatar avatar, int animationPauseTime, int x, int y) {
		super();
		this.animator = animator;
		this.avatar = avatar;
		this.animationPauseTime = animationPauseTime;
		this.x = x;
		this.y = y;
	}

	@Override
	public void run() {
		animator.walkingAnimation(this.avatar, animationPauseTime, this.x, this.y);
	}
}
