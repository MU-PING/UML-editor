package ToolFunction;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import Frame.CanvasTabPane;
import UML.Canvas;
import UML.CanvasObject.ClassBasic;

public class ClassMode extends Mode{
	
	public ClassMode(String displayName, CanvasTabPane canvasTabPane) {
		super(displayName, canvasTabPane);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Canvas canvas = this.canvasTabPane.getCurrentCanvas();
		canvas.addGraphObject(new ClassBasic(canvas, e.getPoint()));
	}
}

