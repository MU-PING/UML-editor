package MenuFunction;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import UML.Canvas;
import UML.CanvasObject.GraphObject;

public class UnGroupMode extends Mode{

	public UnGroupMode(String name) {
		super(name);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Canvas canvas = this.canvasTabPane.getCurrentCanvas();
		ArrayList<GraphObject> selectedGraphObjects = canvas.getSelectedGraphObjects();
		
		if (selectedGraphObjects.size() != 0) {
			for(GraphObject currentObject: selectedGraphObjects) {
				currentObject.clickUnGroup();
		    }
			canvas.clearSelectedGraphObjects();
		}
		else {
			JOptionPane.showMessageDialog(this.canvasTabPane, "Please select one or more components", "Warning",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
