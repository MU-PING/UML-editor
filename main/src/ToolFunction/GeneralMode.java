package ToolFunction;

import UML.Canvas;
import UML.CanvasLine.Association;
import UML.CanvasLine.General;

public class GeneralMode extends LineMode {

	public GeneralMode(String displayName) {
		super(displayName);
	}

	@Override
	public Association generateConnection(Canvas canvas) {
		return new General(canvas, this.startPort, this.endPort);
	}
}
