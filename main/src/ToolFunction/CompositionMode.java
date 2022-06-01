package ToolFunction;

import UML.CanvasLine.Association;
import UML.CanvasLine.Composition;

public class CompositionMode extends LineMode {

	public CompositionMode(String displayName) {
		super(displayName);
	}

	@Override
	public Association generateConnection() {
		return new Composition(this.canvas, this.startPort, this.endPort);
	}

}
