package ToolFunction;

import UML.Canvas;
import UML.CanvasLine.Association;
import UML.CanvasLine.Composition;

public class CompositionMode extends LineMode {

	public CompositionMode(String displayName) {
		super(displayName);
	}

	@Override
	public Association generateConnection(Canvas canvas) {
		return new Composition(canvas, this.startPort, this.endPort);
	}

}
