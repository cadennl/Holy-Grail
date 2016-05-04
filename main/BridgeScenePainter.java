package main;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import drawables.Line;
import drawables.generics.GenericPoint;
import drawables.interfaces.AngleImpl;
import drawables.interfaces.AvatarImpl;
import drawables.interfaces.BridgeImpl;
import drawables.interfaces.ParallelLinesImpl;
import drawables.interfaces.RectangleImpl;
import util.annotations.Tags;

@Tags({"InheritingBridgeScenePainter", "BridgeSceneController"})
public class BridgeScenePainter extends Component implements PropertyChangeListener, MouseListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GenericPoint lastClickPoint;
	private BridgeImpl bridge;
	
	public BridgeScenePainter(Bridge bridge) {
		this.bridge = bridge;
		
		this.bridge.addPropertyChangeListener(this);
		this.bridge.getArthur().addPropertyChangeListener(this);
		this.bridge.getBridge().addPropertyChangeListener(this);
		this.bridge.getGalahad().addPropertyChangeListener(this);
		this.bridge.getGorge().addPropertyChangeListener(this);
		this.bridge.getGuard().addPropertyChangeListener(this);
		this.bridge.getGuardArea().addPropertyChangeListener(this);
		this.bridge.getKnightArea().addPropertyChangeListener(this);
		this.bridge.getLancelot().addPropertyChangeListener(this);
		this.bridge.getRobin().addPropertyChangeListener(this);
		
		this.addMouseListener(this);
		this.addKeyListener(this);
		
		this.setFocusable(true);
		
		this.lastClickPoint = null;
	}
	
	private void drawLine(Graphics2D g, Line l) {
		g.drawLine(l.getX(), l.getY(), l.getX() + l.getWidth(), l.getY() + l.getHeight());
	}
	
	private void drawRect(Graphics2D g, RectangleImpl r) {
		g.drawRect(r.getX(), r.getY(), r.getWidth(), r.getHeight());
	}
	
	private void drawAngle(Graphics2D g, AngleImpl a) {
		drawLine(g, a.getLeftLine());
		drawLine(g, a.getRightLine());
	}
	
	private void drawParallelLines(Graphics2D g, ParallelLinesImpl p) {
		drawLine(g, p.getFirstLine());
		drawLine(g, p.getSecondLine());
	}
	
	private void paintAvatar(Graphics2D g, AvatarImpl a) {
		Image head = Toolkit.getDefaultToolkit().getImage(a.getHead().getImageFileName());
		g.drawImage(head, a.getHead().getX(), a.getHead().getY(), this);
		drawLine(g, a.getBody());
		drawAngle(g, a.getArms());
		drawAngle(g, a.getLegs());
		g.drawString(a.getUtterance().getText(), a.getUtterance().getX(), a.getUtterance().getY());
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		paintAvatar(g2, this.bridge.getArthur());
		paintAvatar(g2, this.bridge.getGalahad());
		paintAvatar(g2, this.bridge.getGuard());
		paintAvatar(g2, this.bridge.getLancelot());
		paintAvatar(g2, this.bridge.getRobin());
		
		drawRect(g2, this.bridge.getGuardArea());
		drawRect(g2, this.bridge.getKnightArea());
		
		drawParallelLines(g2, this.bridge.getGorge());
	}
	
	private void moveAvatarToPoint(AvatarImpl a, int x, int y) {
		a.setX(x);
		a.setY(y);
	}
	
	private void moveAvatarToClick(AvatarImpl a) {
		moveAvatarToPoint(a, this.lastClickPoint.getX(), this.lastClickPoint.getY());
	}
	
	private void moveAllAvatarsToOriginal() {
		AvatarImpl a = this.bridge.getArthur();
		moveAvatarToPoint(this.bridge.getArthur(), a.getOriginalX(), a.getOriginalY());
		a = this.bridge.getGalahad();
		moveAvatarToPoint(this.bridge.getGalahad(), a.getOriginalX(), a.getOriginalY());
		a = this.bridge.getLancelot();
		moveAvatarToPoint(this.bridge.getLancelot(), a.getOriginalX(), a.getOriginalY());
		a = this.bridge.getRobin();
		moveAvatarToPoint(this.bridge.getRobin(), a.getOriginalX(), a.getOriginalY());
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		this.repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent e) {
		char letter = e.getKeyChar();
		if(lastClickPoint != null) {			
			if(letter == 'a') {
				moveAvatarToClick(this.bridge.getArthur());
			} else if(letter == 'g') {
				moveAvatarToClick(this.bridge.getGalahad());
			} else if(letter == 'l') {
				moveAvatarToClick(this.bridge.getLancelot());
			} else if(letter == 'r') {
				moveAvatarToClick(this.bridge.getRobin());
			} else if(letter == 'o') {
				moveAllAvatarsToOriginal();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.lastClickPoint = new GenericPoint(e.getX(), e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
