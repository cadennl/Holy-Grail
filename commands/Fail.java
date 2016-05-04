package commands;

import tokens.WordToken;
import util.annotations.Tags;

@Tags({"fail"})
public class Fail extends WordToken {
	public Fail(String input) {
		super(input);
	}
}