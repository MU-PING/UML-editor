package ToolFunction;
import java.awt.event.MouseEvent;
import Frame.CanvasTabPane;
import UML.Canvas;
import UML.CanvasObject.ClassBasic;
import UML.CanvasObject.UsecaseBasic;

public class UsecaseMode extends Mode{
	
	public UsecaseMode(String displayName){
		super(displayName);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Canvas canvas = this.canvasTabPane.getCurrentCanvas();
		canvas.addGraphObject(new UsecaseBasic(canvas, e.getPoint()));
	
	}

}
