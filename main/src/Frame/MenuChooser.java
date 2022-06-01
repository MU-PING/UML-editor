package Frame;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import MenuFunction.ChangeNameMode;
import MenuFunction.GroupMode;
import MenuFunction.Mode;
import MenuFunction.NewUMLMode;
import MenuFunction.SaveAsMode;
import MenuFunction.SaveMode;
import MenuFunction.UnGroupMode;

public class MenuChooser extends JMenuBar {

	// Help Mode control Canvas
	private ArrayList<Mode> fileMode = new ArrayList<>();
	private ArrayList<Mode> editMode = new ArrayList<>();

	public MenuChooser() {

		// File
		fileMode.add(new NewUMLMode("NewUML"));
		fileMode.add(new SaveMode("Save"));
		fileMode.add(new SaveAsMode("SaveAs"));

		// Edut
		editMode.add(new GroupMode("Group"));
		editMode.add(new UnGroupMode("UnGroup"));
		editMode.add(new ChangeNameMode("ChangeName"));

		// FileMenu-----
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_A);

		fileMenu.add(fileMode.get(0).getItem());
		fileMenu.addSeparator();
		for (int i = 1; i < fileMode.size(); i++) {
			fileMenu.add(fileMode.get(i).getItem());
		}
		this.add(fileMenu);

		// EditMenu-----
		JMenu editMenu = new JMenu("Edit");
		fileMenu.setMnemonic(KeyEvent.VK_B);

		for (int i = 0; i < editMode.size() - 1; i++) {
			editMenu.add(editMode.get(i).getItem());
		}
		editMenu.addSeparator();
		editMenu.add(editMode.get(editMode.size() - 1).getItem());
		this.add(editMenu);
	}
}
