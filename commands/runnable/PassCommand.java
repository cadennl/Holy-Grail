package commands.runnable;

import drawables.interfaces.BridgeImpl;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.Tags;

@PropertyNames({"bridge"}) 
@StructurePattern("Bean Pattern")
@Tags({"PassCommand"})
public class PassCommand extends Command implements Runnable {
	private BridgeImpl bridge;
	
	public PassCommand(BridgeImpl bridge) {
		super();
		this.bridge = bridge;
	}

	@Override
	public void run() {
		this.bridge.passed();
	}

}
