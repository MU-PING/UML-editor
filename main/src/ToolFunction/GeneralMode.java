package ToolFunction;

import UML.Canvas;
import UML.CanvasLine.Association;
import UML.CanvasLine.General;
import UML.CanvasObject.Port;

public class GeneralMode extends LineMode {

	public GeneralMode(String displayName) {
		super(displayName);
	}

	@Override
	public Association generateConnection(Canvas canvas, Port startPort) {
		return new General(canvas, startPort);
	}
}
