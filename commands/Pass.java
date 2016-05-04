package commands;

import tokens.WordToken;
import util.annotations.Tags;

@Tags({"pass"})
public class Pass extends WordToken {
	public Pass(String input) {
		super(input);
	}
}