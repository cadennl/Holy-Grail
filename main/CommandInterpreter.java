 package main;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import drawables.Avatar;
import interfaces.CommandInterpreterImpl;
import interfaces.PropertyListenerSupport;
import util.annotations.EditablePropertyNames;
import util.annotations.ObserverRegisterer;
import util.annotations.ObserverTypes;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.Tags;

@Tags({"CommandInterpreter"})
@PropertyNames({"Command"}) 
@EditablePropertyNames({"Command"})
@StructurePattern("Bean Pattern")
public class CommandInterpreter implements CommandInterpreterImpl {
	private PropertyListenerSupport propertyListenerSupport = new APropertyListenerSupport();
	private Bridge bridgeScene;
	private Parser parser;
	public String Command;
	private TableImpl animators;
	
	public CommandInterpreter(Bridge bridgeScene) {
		super();
		this.bridgeScene = bridgeScene;
		this.parser = new Parser(this.bridgeScene);
		animators = new TableImpl();
		
		Command = "";
		
		animators.put("arthur", new Animator());
		animators.put("galahad", new Animator());
		animators.put("lancelot", new Animator());
		animators.put("robin", new Animator());
	}

	public String getCommand() {
		return Command;
	}

	public void setCommand(String command) {
		String oldCommand = this.Command;
		Command = command;
		
		if(propertyListenerSupport != null) {
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "Command", oldCommand, this.Command));
		}
		
		parser.setCommandText(command);
	}
	
	@Tags({"asynchronousArthur"})
	public void animateArthur() {
		Avatar avatar = bridgeScene.currentKnight("arthur");
		Thread thread = new Thread(new AnimatingClass((Animator) animators.get("arthur"), avatar, 50, 100, 150));
		thread.start();
	} 
	
	@Tags({"asynchronousGalahad"})
	public void animateGalahad() {
		Avatar avatar = bridgeScene.currentKnight("galahad");
		Thread thread = new Thread(new AnimatingClass((Animator) animators.get("galahad"), avatar, 50, 200, 75));
		thread.start();
	}
	
	@Tags({"asynchronousLancelot"})
	public void animateLancelot() {
		Avatar avatar = bridgeScene.currentKnight("lancelot");
		Thread thread = new Thread(new AnimatingClass((Animator) animators.get("lancelot"), avatar, 50, 300, 300));
		thread.start();
	}
	
	@Tags({"asynchronousRobin"})
	public void animateRobin() {
		Avatar avatar = bridgeScene.currentKnight("robin");
		Thread thread = new Thread(new AnimatingClass((Animator) animators.get("robin"), avatar, 50, 150, -100));
		thread.start();
	}
	
	@Override
	@ObserverRegisterer(ObserverTypes.PROPERTY_LISTENER)
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyListenerSupport.addElement(listener);
	}
}
