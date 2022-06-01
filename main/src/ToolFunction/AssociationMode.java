package ToolFunction;

import UML.CanvasLine.Association;

public class AssociationMode extends LineMode {

	public AssociationMode(String displayName) {
		super(displayName);

	}

	@Override
	public Association generateConnection() {
		return new Association(this.canvas, this.startPort, this.endPort);
	}

}
