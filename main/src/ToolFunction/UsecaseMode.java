package ToolFunction;
import java.awt.event.MouseEvent;

import UML.CanvasObject.UsecaseBasic;

public class UsecaseMode extends Mode{
	
	public UsecaseMode(String displayName){
		super(displayName);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		this.canvas.addGraphObject(new UsecaseBasic(canvas, e.getPoint()));
	
	}

}
