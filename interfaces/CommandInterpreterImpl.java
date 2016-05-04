package interfaces;

import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

public interface CommandInterpreterImpl extends PropertyListenerRegisterer{
	public String getCommand();

	public void setCommand(String command);
	
	@Tags({"asynchronousArthur"})
	public void animateArthur();
	
	@Tags({"asynchronousGalahad"})
	public void animateGalahad();
	
	@Tags({"asynchronousLancelot"})
	public void animateLancelot();
	
	@Tags({"asynchronousRobin"})
	public void animateRobin();
}
