package MenuFunction;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import Frame.CanvasTabPane;
import UML.Canvas;
import UML.CanvasObject.GraphObject;

public class UnGroupMode extends Mode{

	public UnGroupMode(String name, CanvasTabPane canvasTabPane) {
		super(name, canvasTabPane);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Canvas canvas = this.canvasTabPane.getCurrentCanvas();
		ArrayList<GraphObject> selectedGraphObjects = canvas.getSelectedGraphObjects();
		for(GraphObject currentObject: selectedGraphObjects) {
			currentObject.clickUnGroup();
	    }
		canvas.clearSelectedGraphObjects();
	}
}
