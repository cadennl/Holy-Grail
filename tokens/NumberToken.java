package tokens;

import interfaces.InputInterface;
import interfaces.NumberTokenInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Numbers"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"Input", "Value"}) 
@EditablePropertyNames({"Input"}) 
public class NumberToken implements InputInterface, NumberTokenInterface{
	String Input;
	private int Value;
	
	public NumberToken(String input) {
		Value = parseInput(input); //parse the input
		Input = input; //Set the input
	}
	
	//How to parse String to integer
	private int parseInput(String input) {
		int output = 0;
		try {
			output = Integer.parseInt(input);
		} catch(Exception ex) {
			
		}
		
		return output;
	}
	
	public String getInput() {
		return Input;
	}
	
	public void setInput(String input) {
		Value = parseInput(input);
		Input = input;
	}
	
	public int getValue() {
		return Value;
	}
}
