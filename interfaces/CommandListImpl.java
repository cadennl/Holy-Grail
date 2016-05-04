package interfaces;

import util.annotations.Tags;

@Tags({"CommandList"})
public interface CommandListImpl {
	public void addCommand(Runnable r);
}
