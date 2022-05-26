package UML.Listener;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import UML.Canvas;
import UML.CanvasObject.GraphObject;


public class ObjectMove extends MouseAdapter{

	protected Canvas canvas ;
	protected GraphObject graphObject;
	
	public ObjectMove(Canvas canvas, GraphObject graphObject) {
		this.canvas = canvas;
		this.graphObject = graphObject;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		this.graphObject.setClickPoint(e.getPoint());
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		this.canvas.clearSelectedGraphObjects();
		this.canvas.addSelectedGraphObject(this.graphObject);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		Point clickPoint = this.graphObject.getClickPoint();
		
		int move_x = e.getPoint().x - clickPoint.x;
		int move_y = e.getPoint().y - clickPoint.y;

		this.graphObject.startPointTranslate(move_x, move_y);
	}
}
