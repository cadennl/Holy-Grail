package commands;

import tokens.WordToken;
import util.annotations.Tags;

@Tags({"sleep"})
public class Sleep extends WordToken {
	public Sleep(String input) {
		super(input);
	}
}