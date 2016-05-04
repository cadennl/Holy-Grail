package main;
import javax.swing.JFrame;

import bus.uigen.ObjectEditor;
import bus.uigen.uiFrame;
import util.misc.ThreadSupport;

public class Assignment11{
	//gets input from the user
	static Bridge bridge = new Bridge();
	static CommandInterpreter commands = new CommandInterpreter(bridge);

	public static void main(String[] args) {
		uiFrame oeFrame = ObjectEditor.edit(bridge);
		oeFrame.setSize(1000, 1000);
		
		uiFrame oeFrame2 = ObjectEditor.edit(commands);
		oeFrame2.setSize(500, 500);
		
		ConsoleSceneView v = new ConsoleSceneView(bridge);
		commands.addPropertyChangeListener(v);
		
		JFrame frame = new JFrame();
		
		frame.add(new BridgeScenePainter(bridge));
		frame.setSize(1000, 1000);
		frame.setVisible(true);
				
		ThreadSupport.sleep(1000);
		
		commands.setCommand("approach Galahad ");
		ThreadSupport.sleep(1000);
		
		commands.setCommand("say \"hi!\" ");
		ThreadSupport.sleep(1000);
		
		commands.setCommand("say \"Hello!\" ");
		ThreadSupport.sleep(1000);
		
		commands.setCommand("approach Robin ");
		ThreadSupport.sleep(1000);
		
		commands.setCommand("passed ");
		ThreadSupport.sleep(1000);
		
		commands.setCommand("approach Robin ");
		ThreadSupport.sleep(1000);
		
		commands.setCommand("say \"You will not pass.!\" ");
		ThreadSupport.sleep(1000);
		
		commands.setCommand("failed ");
		ThreadSupport.sleep(1000);
		
		commands.setCommand("approach Lancelot ");
		
		commands.setCommand("{ move Arthur 50 50 say \"Hi?\" move Galahad 60 40 } ");
		ThreadSupport.sleep(1000);
		
		commands.setCommand("repeat 4 { move Arthur 50 50 say \"Name?\" } ");
		ThreadSupport.sleep(1000);
		
		commands.animateArthur();
		commands.animateArthur();
		commands.animateGalahad();
		commands.animateLancelot();
		commands.animateRobin();
		
		ThreadSupport.sleep(1000);
		commands.animateArthur();
	}
}