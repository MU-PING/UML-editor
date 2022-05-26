package ToolFunction;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import Frame.CanvasTabPane;
import UML.Canvas;

public class AssociationMode extends Mode{
	
	private Point startPoint = null;
	private Point endPoint = null;
	
	public AssociationMode(String displayName){
		super(displayName);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		
		Canvas canvas = this.canvasTabPane.getCurrentCanvas();
	}
}
