package MenuFunction;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import Frame.CanvasTabPane_Singleton;

public class NewUMLMode extends Mode {

	public NewUMLMode(String name) {
		super(name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String input = JOptionPane.showInputDialog(CanvasTabPane_Singleton.getInstance(), "Name", "New UML",
				JOptionPane.INFORMATION_MESSAGE);

		if (input != null) {
			if (input.isEmpty()) {
				CanvasTabPane_Singleton.getInstance().addTab("Untitled");
			} else {
				CanvasTabPane_Singleton.getInstance().addTab(input);
			}
		}
	}
}
