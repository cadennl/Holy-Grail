package commands;

import tokens.WordToken;
import util.annotations.Tags;

@Tags({"call"})
public class Call extends WordToken {
	public Call(String input) {
		super(input);
	}
}