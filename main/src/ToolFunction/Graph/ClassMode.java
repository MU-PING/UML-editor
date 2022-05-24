package ToolFunction.Graph;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import Frame.CanvasTabPane;
import UML.Canvas;
import UML.Graph.Basic.ClassBasic;

public class ClassMode extends GraphMode{
	
	public ClassMode(String displayName, CanvasTabPane canvasTabPane) {
		super(displayName, canvasTabPane);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Canvas canvas = this.canvasTabPane.getCurrentCanvas();
		this.GraphmousePressed(new ClassBasic(canvas, e.getPoint()));
	}
}

