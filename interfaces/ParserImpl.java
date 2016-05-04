package interfaces;

import commands.list.CommandList;
import commands.list.RepeatCommand;
import commands.runnable.ApproachCommand;
import commands.runnable.Command;
import commands.runnable.FailCommand;
import commands.runnable.MoveCommand;
import commands.runnable.PassCommand;
import commands.runnable.SayCommand;
import drawables.Avatar;
import util.annotations.Tags;

public interface ParserImpl {
	public String getCommandText();
	
	public void setCommandText(String command);
	
	public Command getCommandObject();
	
	@Tags({"parseCommand"})
	public Command parseCommand();
	
	@Tags({"parseSay"})
	public SayCommand parseSay(String utterance);
	
	@Tags({"parseFail"})
	public FailCommand parseFail();
	
	@Tags({"parseSay"})
	public PassCommand parsePass();
	
	@Tags({"parseMove"})
	public MoveCommand parseMove(Avatar a, int x, int y);
	
	@Tags({"parseApproach"})
	public ApproachCommand parseApproach(Avatar a);
	
	@Tags({"parseCommandList"})
	public CommandList parseCommandList();
	
	@Tags({"parseRepeat"})
	public RepeatCommand parseRepeat(int count);
}
