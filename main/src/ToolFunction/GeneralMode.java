package ToolFunction;

import UML.CanvasLine.Association;
import UML.CanvasLine.General;

public class GeneralMode extends LineMode{
	
	public GeneralMode(String displayName){
		super(displayName);
	}

	@Override
	public Association generateConnection() {
		return new General(this.canvas, this.startPort, this.endPort);
	}
}
