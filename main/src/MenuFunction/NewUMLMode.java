package MenuFunction;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import Frame.CanvasTabPane;
import UML.Canvas;

public class NewUMLMode extends Mode{

	public NewUMLMode(String name, CanvasTabPane canvasTabPane) {
		super(name, canvasTabPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String input = JOptionPane.showInputDialog(this.canvasTabPane, "Name", "New UML", JOptionPane.INFORMATION_MESSAGE);
		
		if(input!=null) {
			if(input.isEmpty()) {
				this.canvasTabPane.addTab("Untitled");
			}
			else {
				this.canvasTabPane.addTab(input);
			}	
		}
	}
}
