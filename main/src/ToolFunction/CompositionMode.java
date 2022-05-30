package ToolFunction;

import UML.CanvasLine.Composition;
import UML.CanvasLine.Association;

public class CompositionMode extends LineMode{
	
	public CompositionMode(String displayName){
		super(displayName);
	}

	@Override
	public Association generateConnection() {
		return new Composition(this.canvas, this.startPort, this.endPort);
	}

}
