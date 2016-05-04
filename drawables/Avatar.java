package drawables;

import java.beans.PropertyChangeEvent;

import drawables.generics.GenericPoint;
import drawables.interfaces.AvatarImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Avatar"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"utterance", "knight", "head", "arms", "legs", "body", "height", "x", "y", "originalX", "originalY"}) 
@EditablePropertyNames({"utterance", "x", "y"})
public class Avatar extends GenericPoint implements AvatarImpl {
	private Line body;
	private Head head;
	private Angle arms, legs;
	private StringShape utterance;
	private String knight;
	private int height;
	private int originalX, originalY;
	
	public Avatar(String knight, Head head) {
		super(head.getX(), head.getY());
		
		this.originalX = head.getX();
		this.originalY = head.getY();
		
		this.head = head;
		this.knight = knight;
				
		int centerX = head.getX() + 15;
		
		this.body = new Line(centerX, head.getY() + 64, 0, 75);
		this.arms = new Angle(centerX, body.getY()+10, 25, 25);
		this.legs = new Angle(centerX, body.getY()+body.getHeight(), 25, 25);
		
		this.height = 64 + this.body.getHeight() + 25;
		
		this.utterance = new StringShape(head.getX(), head.getY() - 30, "");
	}

	public StringShape getUtterance() {
		return utterance;
	}

	public void setUtterance(StringShape utterance) {
		StringShape oldUtterance = this.utterance;
		this.utterance = utterance;
		
		if(propertyListenerSupport != null) {
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "utterance", oldUtterance, this.utterance));
		}
	}

	public String getKnight() {
		return knight;
	}
	
	public Head getHead() {
		return head;
	}

	public Angle getArms() {
		return arms;
	}

	public Angle getLegs() {
		return legs;
	}

	public Line getBody() {
		return body;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setX(int x) {
		this.move(x-this.getX(), 0);
	}

	public void setY(int y) {
		this.move(0, y-this.getY());
	}

	public int getOriginalX() {
		return originalX;
	}

	public int getOriginalY() {
		return originalY;
	}

	@Tags({"move"})
	public void move(int x, int y) {
		int oldX = this.x;
		int oldY = this.y;
		
		head.move(x, y);
		arms.move(x, y);
		legs.move(x, y);
		body.move(x, y);
		utterance.move(x, y);

		this.x = head.getX();
		this.y = head.getY();
		
		
		if(propertyListenerSupport != null) {
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "x", oldX, this.x));
			propertyListenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "y", oldY, this.y));
		}
	}
}
