package UML.CanvasObject;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import UML.Canvas;
import UML.Listener.ObjectMove;

public class CompositeObject extends GraphObject {

	private ArrayList<GraphObject> selectedGraphObjects;

	public CompositeObject(Canvas canvas, Rectangle pointSize, ArrayList<GraphObject> selectedGraphObjects) {

		super(canvas, pointSize, new Color(238, 248, 233));

		this.move = new ObjectMove(canvas, this);

		this.selectedGraphObjects = selectedGraphObjects;
		this.setLayout(null);
		this.setBorder(new TitledBorder("Group"));
		this.setBackground(this.unselectColor);
		this.addMouseAdapter();

		for (GraphObject currentObject : this.selectedGraphObjects) {
			currentObject.startPointTranslate(-this.startPoint.x, -this.startPoint.y);
			currentObject.deleteMouseAdapter();
			this.add(currentObject);
		}
	}

	@Override
	public void clickUnGroup() {

		for (GraphObject currentObject : this.selectedGraphObjects) {
			Point toPoint = SwingUtilities.convertPoint(this, currentObject.getStartPoint(), this.canvas);
			currentObject.setStartPoint(toPoint);
			currentObject.addMouseAdapter();
			this.canvas.addGraphObject(currentObject);
		}
		this.canvas.ungroupRemove(this);
	}

	@Override
	public void clickChangeName() {
		JOptionPane.showMessageDialog(this, "Composite object has no name", "Warning", JOptionPane.ERROR_MESSAGE);
	}
}
