package ToolFunction.Graph;
import java.awt.event.MouseEvent;
import Frame.CanvasTabPane;
import UML.Canvas;
import UML.Graph.Basic.UsecaseBasic;

public class UsecaseMode extends GraphMode{
	
	public UsecaseMode(String displayName, CanvasTabPane canvasTabPane){
		super(displayName, canvasTabPane);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Canvas canvas = this.canvasTabPane.getCurrentCanvas();
		this.GraphmousePressed(new UsecaseBasic(canvas, e.getPoint()));
	}

}
