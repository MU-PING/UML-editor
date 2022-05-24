package UML.Graph.MouseListener;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import UML.Canvas;
import UML.Graph.GraphObject;


public class MouseObject extends MouseAdapter{

	protected Canvas canvas ;
	protected GraphObject graphObject;
	
	public MouseObject(Canvas canvas, GraphObject graphObject) {
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

		Point startPoint = this.graphObject.getStartPoint();
		Point newStartPoint = new Point(startPoint.x + move_x, startPoint.y + move_y);
		this.graphObject.setStartPoint(newStartPoint);
		this.graphObject.setBounds(this.graphObject.getPointSize());
	}
}
