package commands;

import tokens.WordToken;
import util.annotations.Tags;

@Tags({"undo"})
public class Undo extends WordToken {
	public Undo(String input) {
		super(input);
	}
}