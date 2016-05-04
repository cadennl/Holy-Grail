package commands;

import tokens.WordToken;
import util.annotations.Tags;

@Tags({"define"})
public class Define extends WordToken {
	public Define(String input) {
		super(input);
	}
}