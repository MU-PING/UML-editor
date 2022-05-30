package UML.CanvasObject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

import UML.CanvasLine.Association;

public class Port extends JPanel{

	private Point startPoint;
	private Dimension size;
	private Rectangle pointSize;
	private Point center;
	private ArrayList<Association> connections = new ArrayList<>();

	
	public Port(Point startPoint, int portsize) {
		this.startPoint = startPoint;
		this.size = new Dimension(portsize, portsize);
		this.pointSize = new Rectangle(this.startPoint, this.size);
		this.center = new Point(portsize/2, portsize/2);
		
		// layout
		this.setLayout(null);
		this.setBackground(new Color(156, 156, 156));
		this.setVisible(false);
		
		// setBounds work even if setting layout to BorderLayout
		this.setBounds(this.pointSize);
	}
	
	public Point getCenter() {
		return this.center;
	}
	
	public void setConnection(Association connection) {
		this.connections.add(connection);
	}
	
	public ArrayList<Association> getConnection() {
		return this.connections;
	}
	
	public void removeConnection(Association connection) {
		this.connections.remove(connection);
	}
}
