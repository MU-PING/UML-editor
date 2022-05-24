package UML.Graph.MouseListener;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import UML.Canvas;
import UML.Graph.Basic.BasicObject;
import UML.Graph.Basic.Port;

public class BasicMouse extends MouseObject{

	private BasicObject basicObject;
	
	public BasicMouse(Canvas canvas, BasicObject basicObject) {
		super(canvas, basicObject);
		this.basicObject = basicObject;
	}
	
	public void mouseDragged(MouseEvent e) {
		super.mouseDragged(e);
		
		Point clickPoint = this.basicObject.getClickPoint();
		int move_x = e.getPoint().x - clickPoint.x;
		int move_y = e.getPoint().y - clickPoint.y;
		
		ArrayList<Port> ports= this.basicObject.getPort();
		
		for(Port port : ports){
			
			Point startPoint = port.getStartPoint();
			Point newStartPoint = new Point(startPoint.x + move_x, startPoint.y + move_y);
			port.setStartPoint(newStartPoint);
			port.setBounds(newStartPoint.x, newStartPoint.y, port.getPortsize(), port.getPortsize());
		}
	}
}