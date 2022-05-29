package UML.CanvasObject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import UML.Canvas;

public class CompositeObject extends GraphObject {

	private ArrayList<GraphObject> selectedGraphObjects;
	private ArrayList<Connection> connections;

	public CompositeObject(Canvas canvas, Rectangle pointSize, ArrayList<GraphObject> selectedGraphObjects,
			ArrayList<Connection> connections) {

		super(canvas, pointSize, new Color(238, 248, 233));

		this.selectedGraphObjects = selectedGraphObjects;
		this.connections = connections;

		this.setLayout(null);
		this.setBorder(new TitledBorder("Group"));
		this.setBackground(this.unselectColor);
		this.addSelectModeAdapter();

		for (GraphObject currentObject : this.selectedGraphObjects) {
			currentObject.startPointTranslate(-this.startPoint.x, -this.startPoint.y);
			currentObject.deleteSelectModeAdapter();
			this.add(currentObject);
		}
		this.repaint();
	}

	@Override
	public void clickUnGroup() {

		for (GraphObject currentObject : this.selectedGraphObjects) {
			Point toPoint = SwingUtilities.convertPoint(this, currentObject.getStartPoint(), this.canvas);
			currentObject.setStartPoint(toPoint);
			currentObject.addSelectModeAdapter();
			this.canvas.addGraphObject(currentObject);
		}
		
		for(Connection currentObject: this.connections) {
			this.canvas.addConnection(currentObject);
		}
		
		this.canvas.ungroupRemove(this);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Port port1;
		Port port2;
		Point toPoint1;
		Point toPoint2;

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(79, 79, 79));

		for (Connection connect : this.connections) {
			port1 = connect.getPort1();
			port2 = connect.getPort2();

			toPoint1 = SwingUtilities.convertPoint(port1, port1.getCenter(), this);
			toPoint2 = SwingUtilities.convertPoint(port2, port2.getCenter(), this);

			g2.drawLine(toPoint1.x, toPoint1.y, toPoint2.x, toPoint2.y);
		}
	}
}
