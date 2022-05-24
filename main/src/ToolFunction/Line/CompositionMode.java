package ToolFunction.Line;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import Frame.CanvasTabPane;
import ToolFunction.Mode;
import UML.Canvas;

public class CompositionMode extends Mode{
	
	private Point startPoint = null;
	private Point endPoint = null;
	
	public CompositionMode(String displayName, CanvasTabPane canvasTabPane){
		super(displayName, canvasTabPane);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
	}
}
