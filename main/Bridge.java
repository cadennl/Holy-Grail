package main;

import java.beans.PropertyChangeEvent;

import drawables.Avatar;
import drawables.Head;
import drawables.ParallelLines;
import drawables.Rectangle;
import drawables.StringShape;
import drawables.generics.GenericPoint;
import drawables.interfaces.BridgeImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"BridgeScene"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"arthur", "lancelot", "robin", "galahad", "guard", "knightArea", "guardArea", "Occupied", "KnightTurn", "gorge",
					"bridge"}) 
@EditablePropertyNames({"x", "y"})
public class Bridge extends GenericPoint implements BridgeImpl {
	private Avatar arthur, lancelot, robin, galahad, guard;
	private Rectangle knightArea, guardArea;
	private ParallelLines gorge;
	private Rectangle bridge;
	private boolean Occupied = false, KnightTurn = false;
	@Visible(false)
	private String currentKnight;
	
	public Bridge() {
		super(0,0);
				
		arthur = new Avatar("arthur", new Head(10, 10, "src/arthur.jpg"));
		lancelot = new Avatar("lancelot", new Head(60, 10, "src/lancelot.jpg"));
		robin = new Avatar("robin", new Head(10, 200, "src/robin.jpg"));
		galahad = new Avatar("galahad", new Head(50, 200, "src/galahad.jpg"));
		guard = new Avatar("guard", new Head(320, 50, "src/guard.jpg"));
				
		//Gorge & Bridge
		this.gorge = new ParallelLines(400, 0, 0, 600, true, 100);
		this.bridge = new Rectangle(400, 150, 100, 50);
		
		this.guardArea = new Rectangle(300, 150, 75, 75);
		this.knightArea = new Rectangle(200, 150, 75, 75);
	}

	public Avatar getArthur() {
		return arthur;
	}

	public Avatar getLancelot() {
		return lancelot;
	}

	public Avatar getRobin() {
		return robin;
	}

	public Avatar getGalahad() {
		return galahad;
	}

	public Avatar getGuard() {
		return guard;
	}

	public Rectangle getKnightArea() {
		return knightArea;
	}

	public Rectangle getGuardArea() {
		return guardArea;
	}

	public ParallelLines getGorge() {
		return gorge;
	}

	public Rectangle getBridge() {
		return bridge;
	}

	public boolean isOccupied() {
		return Occupied;
	}

	public boolean isKnightTurn() {
		return KnightTurn;
	}
	
	public boolean preApproach(Avatar avatar) {
		return avatar != null && !this.Occupied;
	}

	@Tags({"approach"})
	public void approach(Avatar a) {
		assert preApproach(a);
		if(propertyListenerSupport != null) {
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "say", true));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "pass", true));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "approach", false));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "fail", true));
		}
		if(!this.Occupied) {
			currentKnight(a.getKnight()).move((knightArea.getX() - a.getHead().getX())+25, (knightArea.getY() - a.getHeight())-a.getHead().getY() + 40);
			this.Occupied = true;
			this.currentKnight = a.getKnight();
		}
	}
	
	public boolean prePass() {
		return this.Occupied && !this.KnightTurn;
	}
	
	@Tags({"passed"})
	public void passed() {
		assert prePass();
		if(propertyListenerSupport != null) {
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "say", false));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "pass", false));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "approach", true));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "fail", false));
		}
		if(this.Occupied && !this.KnightTurn) {
			currentKnight(this.currentKnight).move(200, 0);
			currentKnight = null;
			this.Occupied = false;
			this.KnightTurn = false;
		}
	}
	
	public boolean preFail() {
		return this.Occupied;
	}
	
	@Tags({"failed"})
	public void failed() {
		assert preFail();
		if(propertyListenerSupport != null) {
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "say", false));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "pass", false));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "approach", true));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "this", "fail", false));
		}
		if(this.Occupied) {
			if(!this.KnightTurn) {
				guard.move(100, 150);
				passed();
			} else {
				currentKnight(this.currentKnight).move(200, 200);
				this.Occupied = false;
				this.currentKnight = null;
			}
		}
	}
	
	public boolean preSay(String utterance) {
		return utterance != null && this.Occupied;
	}
	
	@Tags({"say"})
	public void say(String utterance) {
		assert preSay(utterance);
		if(this.Occupied) {
			if(this.KnightTurn) {
				Avatar a = currentKnight(this.currentKnight);
				currentKnight(this.currentKnight).setUtterance(new StringShape(a.getHead().getX(), a.getHead().getY() - 20, utterance));
				this.KnightTurn = false;
			} else {
				guard.setUtterance(new StringShape(guard.getHead().getX(), guard.getHead().getY() - 20, utterance));
				this.KnightTurn = true;
			}
		}
	}
	
	public Avatar currentKnight(String knight) {		
		if(this.arthur.getKnight().equalsIgnoreCase(knight)) 
			return this.arthur;
		else if(this.lancelot.getKnight().equalsIgnoreCase(knight))
			return this.lancelot;
		else if(this.galahad.getKnight().equalsIgnoreCase(knight))
			return this.galahad;
		else if(this.guard.getKnight().equalsIgnoreCase(knight))
			return this.guard;
		else if(this.robin.getKnight().equalsIgnoreCase(knight))
			return this.robin;
			
		return null;
	}
}
