package ToolFunction;

import java.awt.event.MouseEvent;

import UML.CanvasObject.ClassBasic;

public class ClassMode extends Mode {

	public ClassMode(String displayName) {
		super(displayName);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.canvas.addGraphObject(new ClassBasic(this.canvas, e.getPoint()));
	}
}
