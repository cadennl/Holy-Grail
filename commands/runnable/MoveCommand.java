package commands.runnable;

import drawables.Avatar;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.Tags;

@PropertyNames({"avatar", "x", "y"}) 
@StructurePattern("Bean Pattern")
@Tags({"MoveCommand"})
public class MoveCommand extends Command implements Runnable {
	private Avatar avatar;
	private int x, y;
	
	public MoveCommand(Avatar avatar, int x, int y) {
		super();
		this.avatar = avatar;
		this.x = x;
		this.y = y;
	}

	@Override
	public void run() {
		this.avatar.move(this.x, this.y);
	}

}
