package ToolFunction;

import java.awt.event.MouseEvent;

import UML.Canvas;
import UML.CanvasObject.ClassBasic;

public class ClassMode extends Mode {

	public ClassMode(String displayName) {
		super(displayName);
	}

	@Override
	public void mousePressed(MouseEvent e, Canvas canvas) {
		canvas.addGraphObject(new ClassBasic(canvas, e.getPoint()));
	}
}
