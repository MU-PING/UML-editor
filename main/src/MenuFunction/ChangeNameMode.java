package MenuFunction;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Frame.CanvasTabPane;
import UML.Canvas;
import UML.CanvasObject.GraphObject;

public class ChangeNameMode extends Mode{

	public ChangeNameMode(String name, CanvasTabPane canvasTabPane) {
		super(name, canvasTabPane);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Canvas canvas = this.canvasTabPane.getCurrentCanvas();
		ArrayList<GraphObject> selectedGraphObjects = canvas.getSelectedGraphObjects();
		
		if(selectedGraphObjects.size() == 1) {
			selectedGraphObjects.get(0).clickChangeName();
		}
		
		else if (selectedGraphObjects.size() > 1){
			JOptionPane.showMessageDialog(this.canvasTabPane, "Selected more than one component", "Warning", JOptionPane.ERROR_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(this.canvasTabPane, "Please select one basic object", "Warning", JOptionPane.ERROR_MESSAGE);
		}
	}

}
