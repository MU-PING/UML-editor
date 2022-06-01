package ToolFunction;

import UML.Canvas;
import UML.CanvasLine.Association;

public class AssociationMode extends LineMode {

	public AssociationMode(String displayName) {
		super(displayName);

	}

	@Override
	public Association generateConnection(Canvas canvas) {
		return new Association(canvas, this.startPort, this.endPort);
	}

}
