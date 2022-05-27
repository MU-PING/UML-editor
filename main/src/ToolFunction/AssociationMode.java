package ToolFunction;

import java.awt.Point;
import java.awt.event.ActionEvent;

import UML.Canvas;

public class AssociationMode extends Mode {

	private Point startPoint = null;
	private Point endPoint = null;

	public AssociationMode(String displayName) {
		super(displayName);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);

		Canvas canvas = this.canvasTabPane.getCurrentCanvas();
	}
}
