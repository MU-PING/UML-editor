package UML.Graph.Composite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.border.TitledBorder;

import UML.Canvas;
import UML.Graph.GraphObject;
import UML.Graph.MouseListener.MouseObject;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class CompositeObject extends GraphObject{

	private ArrayList<GraphObject> selectedGraphObjects;

	public CompositeObject(Canvas canvas, Rectangle pointSize, ArrayList<GraphObject> selectedGraphObjects) {
		
		super(canvas, pointSize, new Color(238,248,233));
		
		this.mouseAdapter = new MouseObject(canvas, this);
		
		this.selectedGraphObjects = selectedGraphObjects;
		this.setLayout(null);
		this.setBorder(new TitledBorder("Group"));
		this.setBackground(this.unselectColor);
		this.addSelectMouseAdapter();
		
		for( GraphObject currentObject: this.selectedGraphObjects ) {
			Point point = currentObject.getStartPoint();
			point.translate(-this.startPoint.x, -this.startPoint.y);

			currentObject.setStartPoint(point);
			currentObject.setBounds(new Rectangle(point, currentObject.getDimension()));
			currentObject.deleteSelectMouseAdapter();
			this.add(currentObject);
		}
	}
	
	@Override
	public void clickUnGroup() {
		
		for(GraphObject currentObject: this.selectedGraphObjects) {
			Point toPoint = SwingUtilities.convertPoint(this, currentObject.getStartPoint(), this.canvas);
			currentObject.setStartPoint(toPoint);
			currentObject.setBounds(new Rectangle(toPoint, currentObject.getDimension()));
			currentObject.addSelectMouseAdapter();
			this.canvas.addGraphObject(currentObject);
	    }
		this.canvas.ungroupRemove(this);
	}

	@Override
	public void clickChangeName() {
		JOptionPane.showMessageDialog(this, "Composite object has no name", "Warning", JOptionPane.ERROR_MESSAGE);
	} 
}
