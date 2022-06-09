package ToolFunction;

import UML.Canvas;
import UML.CanvasLine.Association;
import UML.CanvasObject.Port;

public class AssociationMode extends LineMode {

	public AssociationMode(String displayName) {
		super(displayName);

	}

	@Override
	public Association generateConnection(Canvas canvas, Port startPort) {
		return new Association(canvas, startPort);
	}

}
