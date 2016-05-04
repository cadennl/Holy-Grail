package commands;

import tokens.WordToken;
import util.annotations.Tags;

@Tags({"move"})
public class Move extends WordToken {
	public Move(String input) {
		super(input);
	}
}