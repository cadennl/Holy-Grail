package commands;

import tokens.WordToken;
import util.annotations.Tags;

@Tags({"say"})
public class Say extends WordToken {
	public Say(String input) {
		super(input);
	}
}