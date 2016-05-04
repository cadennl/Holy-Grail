package tokens;

import interfaces.InputInterface;
import interfaces.WordTokenInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Word"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"Input", "Value"}) 
@EditablePropertyNames({"Input"}) 
public class WordToken implements InputInterface, WordTokenInterface {
	String Input;
	private String Value; //lowercase representation of String

	public WordToken(String input) {
		Input = input;
		Value = parseInput(input);
	}
	
	//How to parse String to lowercase
	private String parseInput(String input) {			
		return input.toLowerCase();
	}

	public String getInput() {
		return Input;
	}

	public void setInput(String input) {
		Input = input;
	}

	public String getValue() {
		return Value;
	}
}
