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
import commands.Thread;
import commands.Undo;
import commands.Wait;
import interfaces.BeanInterface;
import interfaces.InputInterface;
import tokens.EndToken;
import tokens.NumberToken;
import tokens.QuotedStringToken;
import tokens.StartToken;
import tokens.WordToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"Bean"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"ScannedString", "tokens"})
@EditablePropertyNames({"ScannedString"})
public class Bean implements BeanInterface {
	String ScannedString;
	
	@Visible(false)
	private static InputInterface[] largeTokenArray;
	private InputInterface[] tokens;
	
	private static int count;

	public Bean(){
		ScannedString = "";
		largeTokenArray = new InputInterface[10];
		tokens = new InputInterface[0];
		count = 0;
	}
	
	public InputInterface[] getTokens() {
		tokens = new InputInterface[count];
		for(int i = 0; i < tokens.length; i++) {
			tokens[i] = largeTokenArray[i];
		}
		return tokens;
	}
	
	public String getScannedString() {
		return ScannedString;
	}

	public void setScannedString(String scannedString) {
		ScannedString = scannedString;
		largeTokenArray = new InputInterface[scannedString.length()];
		tokens = new InputInterface[10];
		count = 0;
		parseInput(ScannedString);
	}

	public static void parseInput(String input) {							
		for(int i = 0; i < input.length()-1; i++) {			
			char c = input.charAt(i);

			if(c == '"') {
				i++;
				c = input.charAt(i);
				String token_string = "";

				while(c != '"') {
					token_string += c;
					i++;
					c = input.charAt(i);
				}
				i++;

				largeTokenArray[count++] = new QuotedStringToken(token_string);
			} else if(c == '{') {
				largeTokenArray[count++] = new StartToken("" + c);
				i++;
				c = input.charAt(i);
			} else if(c == '}') {
				largeTokenArray[count++] = new EndToken("" + c);
				i++;
				c = input.charAt(i);
			} else {
				//If the character's not a quote ", it's either a number or character
				if(Character.isDigit(c)) {						
					String token_string = "";

					while(Character.isDigit(c)) {
						token_string += c;
						i++;
						c = input.charAt(i);
					}

					largeTokenArray[count++] = new NumberToken(token_string);
				} else {						
					String token_string = "";

					while(c != ' ') {
						token_string += c;

						i++;
						c = input.charAt(i);
					}
					
					if(!parseWordToken(token_string)) {
						largeTokenArray[count++] = new WordToken(token_string);
					}
				}
			}
		}		
	}
	
	private static boolean parseWordToken(String token_string) {
		int temp = count;
		
		if(token_string.equalsIgnoreCase("move")) {
			largeTokenArray[count++] = new Move(token_string);
		} else if(token_string.equalsIgnoreCase("say")) {
			largeTokenArray[count++] = new Say(token_string);
		} else if(token_string.equalsIgnoreCase("rotateLeftArm")) {
			largeTokenArray[count++] = new RotateLeftArm(token_string);
		} else if(token_string.equalsIgnoreCase("rotateRightArm")) {
			largeTokenArray[count++] = new RotateRightArm(token_string);
		} else if(token_string.equalsIgnoreCase("repeat")) {
			largeTokenArray[count++] = new Repeat(token_string);
		} else if(token_string.equalsIgnoreCase("define")) {
			largeTokenArray[count++] = new Define(token_string);
		} else if(token_string.equalsIgnoreCase("call")) {
			largeTokenArray[count++] = new Call(token_string);
		} else if(token_string.equalsIgnoreCase("thread")) {
			largeTokenArray[count++] = new Thread(token_string);
		} else if(token_string.equalsIgnoreCase("wait")) {
			largeTokenArray[count++] = new Wait(token_string);
		} else if(token_string.equalsIgnoreCase("proceedAll")) {
			largeTokenArray[count++] = new ProceedAll(token_string);
		} else if(token_string.equalsIgnoreCase("sleep")) {
			largeTokenArray[count++] = new Sleep(token_string);
		} else if(token_string.equalsIgnoreCase("undo")) {
			largeTokenArray[count++] = new Undo(token_string);
		} else if(token_string.equalsIgnoreCase("redo")) {
			largeTokenArray[count++] = new Redo(token_string);
		} else if(token_string.equalsIgnoreCase("approach")) {
			largeTokenArray[count++] = new Approach(token_string);
		} else if(token_string.equalsIgnoreCase("passed")) {
			largeTokenArray[count++] = new Pass(token_string);
		} else if(token_string.equalsIgnoreCase("failed")) {
			largeTokenArray[count++] = new Fail(token_string);
		}
		
		return temp != count;
	}
}
