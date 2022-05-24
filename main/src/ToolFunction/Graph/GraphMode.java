package ToolFunction.Graph;

import java.awt.Point;
import java.awt.event.MouseEvent;

import Frame.CanvasTabPane;
import ToolFunction.Mode;
import UML.Canvas;
import UML.Graph.Basic.BasicObject;
import UML.Graph.Basic.Port;

public abstract class GraphMode extends Mode{
	private Port port;
	
	protected GraphMode(String name, CanvasTabPane canvasTabPane) {
		super(name, canvasTabPane);
	}
	
	protected void GraphmousePressed(BasicObject basicGraph) {
		
		Canvas canvas = this.canvasTabPane.getCurrentCanvas();
		canvas.addGraphObject(basicGraph);
		
		
		Port port;
		int x, y, portSize = 10;
		int startx = basicGraph.getStartPoint().x;
		int starty = basicGraph.getStartPoint().y;
		int width = basicGraph.getDimension().width;
		int height = basicGraph.getDimension().height;
		
		// top
		x = startx + (width - portSize)/2;
		y = starty - portSize;
		port = new Port(new Point(x, y), portSize);
		basicGraph.setPort(port);
		canvas.add(port);
		canvas.setComponentZOrder(port, 0);
		
		// left
		x = startx - portSize;
		y = starty + (height - portSize)/2;
		port = new Port(new Point(x, y), portSize);
		basicGraph.setPort(port);
		canvas.add(port);
		canvas.setComponentZOrder(port, 0);
		
		// right
		x = startx + width;
		y = starty + (height-portSize)/2;
		port = new Port(new Point(x, y), portSize);
		basicGraph.setPort(port);
		canvas.add(port);
		canvas.setComponentZOrder(port, 0);
		
		// bottom
		x = startx + (width-portSize)/2;
		y = starty + height;
		port = new Port(new Point(x, y), portSize);
		basicGraph.setPort(port);
		canvas.add(port);
		canvas.setComponentZOrder(port, 0);
		
	}
}
