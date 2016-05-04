package main;

import commands.Approach;
import commands.Call;
import commands.Define;
import commands.Fail;
import commands.Move;
import commands.Pass;
import commands.ProceedAll;
import commands.Redo;
import commands.Repeat;
import commands.RotateLeftArm;
import commands.RotateRightArm;
import commands.Say;
import commands.Sleep;
import commands.Undo;
import commands.Wait;
import commands.list.CommandList;
import commands.list.RepeatCommand;
import commands.runnable.ApproachCommand;
import commands.runnable.Command;
import commands.runnable.FailCommand;
import commands.runnable.MoveCommand;
import commands.runnable.PassCommand;
import commands.runnable.SayCommand;
import drawables.Avatar;
import drawables.interfaces.BridgeImpl;
import interfaces.InputInterface;
import interfaces.ParserImpl;
import tokens.EndToken;
import tokens.NumberToken;
import tokens.StartToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.Tags;

@PropertyNames({"CommandObject", "CommandText"}) 
@EditablePropertyNames({"CommandText"})
@StructurePattern("Bean Pattern")
public class Parser implements ParserImpl {
	private BridgeImpl bridgeScene;
	private Bean beanScanner;
	private TableImpl avatars;
	private InputInterface[] tokens;
	public Command CommandObject;
	private int index;
	public String CommandText;
	
	public Parser(BridgeImpl bridge) {
		super();
		this.bridgeScene = bridge;
		this.beanScanner = new Bean();
		
		tokens = new InputInterface[10];
		index = 0;
		
		avatars = new TableImpl();
		avatars.put("arthur", bridge.getArthur());
		avatars.put("galahad", bridge.getGalahad());
		avatars.put("lancelot", bridge.getLancelot());
		avatars.put("robin", bridge.getRobin());
		avatars.put("guard", bridge.getGuard());
	}
	
	public String getCommandText() {
		return CommandText;
	}
	
	public void setCommandText(String command) {
		this.CommandText = command;
		
		index = 0;
		beanScanner.setScannedString(this.CommandText);
		tokens = beanScanner.getTokens();
		CommandObject = parseCommand();
		System.out.println(CommandObject.getClass().getName());
		CommandObject.run();
	}
	
	public Command getCommandObject() {
		return CommandObject;
	}
	
	@Tags({"parseCommand"})
	public Command parseCommand() {
		for(; index < tokens.length; index++) {
			InputInterface command = tokens[index++];

			if(command instanceof Approach) {
				return parseApproach(bridgeScene.currentKnight(tokens[index++].getInput()));
			} else if(command instanceof Call) {
				
			} else if(command instanceof Define) {
				
			} else if(command instanceof Move) {
				String input = tokens[index++].getInput();
				int x = ((NumberToken) tokens[index++]).getValue();
				int y = ((NumberToken) tokens[index++]).getValue();
				return parseMove(this.bridgeScene.currentKnight(input), x, y);
			} else if(command instanceof ProceedAll) {
				
			} else if(command instanceof Redo) {
				
			} else if(command instanceof Repeat) {
				return parseRepeat(((NumberToken) tokens[index]).getValue());
			} else if(command instanceof RotateLeftArm) {
				
			} else if(command instanceof RotateRightArm) {
				
			} else if(command instanceof Say) {
				return parseSay(tokens[index++].getInput());
			} else if(command instanceof Sleep) {
				
			} else if(command instanceof Thread) {
				
			} else if(command instanceof Undo) {
				
			} else if(command instanceof Wait) {
				
			} else if(command instanceof Pass) {
				return parsePass();
			} else if(command instanceof Fail) {
				return parseFail();
			} else if(command instanceof StartToken) {
				return parseCommandList();
			}
		}
		
		return null;
	}
	
	@Tags({"parseSay"})
	public SayCommand parseSay(String utterance) {
		return new SayCommand(this.bridgeScene, utterance);
	}
	
	@Tags({"parseFail"})
	public FailCommand parseFail() {
		return new FailCommand(this.bridgeScene);
	}
	
	@Tags({"parsePass"})
	public PassCommand parsePass() {
		return new PassCommand(this.bridgeScene);
	}
	
	@Tags({"parseMove"})
	public MoveCommand parseMove(Avatar a, int x, int y) {
		return new MoveCommand(a, x, y);
	}
	
	@Tags({"parseApproach"})
	public ApproachCommand parseApproach(Avatar a) {
		return new ApproachCommand(this.bridgeScene, a);
	}
	
	@Tags({"parseCommandList"})
	public CommandList parseCommandList() {
		CommandList cl = new CommandList();
		while(!(tokens[index] instanceof EndToken)) {
			cl.addCommand(parseCommand());
		}
		index++;
		return cl;
	}
	
	@Tags({"parseRepeat"})
	public RepeatCommand parseRepeat(int count) {
		return new RepeatCommand(parseCommand(), count);
	}
}