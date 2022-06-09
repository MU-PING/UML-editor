package ToolFunction;

import UML.Canvas;
import UML.CanvasLine.Association;
import UML.CanvasLine.Composition;
import UML.CanvasObject.Port;

public class CompositionMode extends LineMode {

	public CompositionMode(String displayName) {
		super(displayName);
	}

	@Override
	public Association generateConnection(Canvas canvas, Port startPort) {
		return new Composition(canvas, startPort);
	}

}
