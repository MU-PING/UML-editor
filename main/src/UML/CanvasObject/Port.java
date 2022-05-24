package UML.CanvasObject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class Port extends JPanel{

	private Point startPoint;
	private Dimension size;
	private Rectangle pointSize;
	private int portsize;
	
	public Port(Point startPoint, int portsize) {
		this.startPoint = startPoint;
		this.size = new Dimension(portsize, portsize);
		this.pointSize = new Rectangle(this.startPoint, this.size);
		this.portsize = portsize;
		
		// layout
		this.setLayout(null);
		this.setBackground(new Color(156, 156, 156));
		this.setVisible(false);
		this.setBounds(this.pointSize);
	}
	
	public void startPointTranslate(int movex, int movey) {
		this.startPoint.translate(movex, movey);
		this.pointSize.setLocation(this.startPoint);
		this.setBounds(this.pointSize);
	}
	
	public Point getStartPoint() {
		return this.startPoint;
	}
	
	public int getPortsize() {
		return this.portsize;
	}
	
}
