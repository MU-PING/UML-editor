package MenuFunction;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Frame.CanvasTabPane_Singleton;
import UML.Canvas;
import UML.CanvasObject.GraphObject;

public class ChangeNameMode extends Mode {

	public ChangeNameMode(String name) {
		super(name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Canvas canvas = CanvasTabPane_Singleton.getInstance().getCurrentCanvas();
		ArrayList<GraphObject> selectedGraphObjects = canvas.getSelectedGraphObjects();

		if (selectedGraphObjects.size() == 1) {
			selectedGraphObjects.get(0).clickChangeName();
		}

		else if (selectedGraphObjects.size() > 1) {
			JOptionPane.showMessageDialog(CanvasTabPane_Singleton.getInstance(), "Selected more than one component",
					"Warning", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(CanvasTabPane_Singleton.getInstance(), "Please select one basic component",
					"Warning", JOptionPane.ERROR_MESSAGE);
		}
	}
}
