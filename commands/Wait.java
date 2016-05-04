package commands;

import tokens.WordToken;
import util.annotations.Tags;

@Tags({"wait"})
public class Wait extends WordToken {
	public Wait(String input) {
		super(input);
	}
}