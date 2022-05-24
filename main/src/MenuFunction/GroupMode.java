package MenuFunction;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Frame.CanvasTabPane;
import UML.Canvas;
import UML.CanvasObject.CompositeObject;
import UML.CanvasObject.GraphObject;

public class GroupMode extends Mode{

	public GroupMode(String name, CanvasTabPane canvasTabPane) {
		super(name, canvasTabPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Canvas canvas = this.canvasTabPane.getCurrentCanvas();
		ArrayList<GraphObject> selectedGraphObjects = canvas.getSelectedGraphObjects();
		Rectangle pointSize = calcCompositeObject(selectedGraphObjects);
		
		// group selected objects
		CompositeObject compositeObject = new CompositeObject(canvas, pointSize, selectedGraphObjects);
		
		canvas.groupRemove();
		canvas.clearSelectedGraphObjects();
		canvas.addGraphObject(compositeObject);
	}
	
	private Rectangle calcCompositeObject(ArrayList<GraphObject> selectedGraphObjects) {
		
		ArrayList<Point> point_upper_left = new ArrayList<Point>();
		ArrayList<Point> point_lower_right = new ArrayList<Point>();
		int top, bottom, left, right;
		int padding = 20;
		
		for( GraphObject currentObject: selectedGraphObjects ) {
			
			point_upper_left.add(currentObject.getStartPoint());
			point_lower_right.add(currentObject.getEndPoint());
	    }
		
		// no efficiency, can be improved
		Collections.sort(point_upper_left, new PointSortX());
		left = point_upper_left.get(0).x - padding;
		
		Collections.sort(point_upper_left, new PointSortY());
		top = point_upper_left.get(0).y - (padding+10);
		
		Collections.sort(point_lower_right, new PointSortX()); 
		right = point_lower_right.get(point_lower_right.size()-1).x + padding;
		
		Collections.sort(point_lower_right, new PointSortY());
		bottom = point_lower_right.get(point_lower_right.size()-1).y + padding;
		
		
		Rectangle pointSize = new Rectangle(left, top, right - left, bottom - top);
		
		return pointSize;
		
	}
	
	class PointSortX implements Comparator<Point> 
	{ 
		@Override
		public int compare(Point o1, Point o2) {
			return o1.x - o2.x;
		} 
	} 
	
	class PointSortY implements Comparator<Point> 
	{ 
		@Override
		public int compare(Point o1, Point o2) {
			return o1.y - o2.y;
		} 
	}
	
}
