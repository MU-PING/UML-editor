package ToolFunction;

import java.awt.Point;
import java.awt.event.ActionEvent;

import Frame.CanvasTabPane;

public class CompositionMode extends Mode{
	
	private Point startPoint = null;
	private Point endPoint = null;
	
	public CompositionMode(String displayName){
		super(displayName);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
	}
}
