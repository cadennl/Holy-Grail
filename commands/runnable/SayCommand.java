package commands.runnable;

import drawables.interfaces.BridgeImpl;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.Tags;

@PropertyNames({"scene", "utterance"}) 
@Tags({"SayCommand"})
@StructurePattern("Bean Pattern")
public class SayCommand extends Command implements Runnable {
	private BridgeImpl scene;
	private String utterance;

	public SayCommand(BridgeImpl scene, String utterance) {
		this.scene = scene;
		this.utterance = utterance;
	}
	
	@Override
	public void run() {
		this.scene.say(this.utterance);
	}

}
