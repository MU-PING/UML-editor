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
import UML.CanvasLine.Association;

public class CompositeObject extends GraphObject {

	private ArrayList<GraphObject> selectedGraphObjects;
	private ArrayList<Association> connections;

	public CompositeObject(Canvas canvas, Rectangle pointSize, ArrayList<GraphObject> selectedGraphObjects,
			ArrayList<Association> connections) {

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
		
		for (Association currentObject : this.connections) {
			currentObject.setJPanel(this);
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
		
		for(Association currentObject: this.connections) {
			currentObject.setJPanel(this.canvas);
			this.canvas.addConnection(currentObject);
		}
		
		this.canvas.ungroupRemove(this);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		for(Association current : this.connections) {
			current.drawLine(g);
		}
	}
}
