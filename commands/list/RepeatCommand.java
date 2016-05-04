package commands.list;

import commands.runnable.Command;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"command", "count"}) 
@Tags({"Repeat"})
public class RepeatCommand extends Command implements Runnable{
	public Command command;
	public int count;
	
	public RepeatCommand(Command command, int count) {
		super();
		this.command = command;
		this.count = count;
	}
	
	public void run() {
		for(int i = 0; i < count; i++) {
			ThreadSupport.sleep(100);
			this.command.run();
		}
	}
}
