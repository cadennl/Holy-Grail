package commands.runnable;

import drawables.Avatar;
import drawables.interfaces.BridgeImpl;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.Tags;

@PropertyNames({"avatar", "bridge"}) 
@StructurePattern("Bean Pattern")
@Tags({"ApproachCommand"})
public class ApproachCommand extends Command implements Runnable {
	private Avatar avatar;
	private BridgeImpl bridge;
	
	public ApproachCommand(BridgeImpl bridge, Avatar avatar) {
		super();
		this.avatar = avatar;
		this.bridge = bridge;
	}

	@Override
	public void run() {
		this.bridge.approach(avatar);
	}

}
