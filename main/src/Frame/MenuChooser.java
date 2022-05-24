package Frame;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import MenuFunction.*;


public class MenuChooser extends JMenuBar {
	
	// Help Mode control Canvas
	private CanvasTabPane canvasTabPane;
	private ArrayList<Mode> fileMode = new ArrayList<>();
	private ArrayList<Mode> editMode = new ArrayList<>();
	
	public MenuChooser(CanvasTabPane canvasTabPane) {

		this.canvasTabPane = canvasTabPane;
		
		// File
		fileMode.add(new NewUMLMode("NewUML", this.canvasTabPane));
		fileMode.add(new SaveMode("Save", this.canvasTabPane));
		fileMode.add(new SaveAsMode("SaveAs", this.canvasTabPane));
		
		// Edut 
		editMode.add(new GroupMode("Group", this.canvasTabPane));
		editMode.add(new UnGroupMode("UnGroup", this.canvasTabPane));
		editMode.add(new ChangeNameMode("ChangeName", this.canvasTabPane));
		
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

		for (int i = 0; i < editMode.size()-1; i++) {
			editMenu.add(editMode.get(i).getItem());
		}
		editMenu.addSeparator();
		editMenu.add(editMode.get(editMode.size()-1).getItem());
		this.add(editMenu);
		this.setPreferredSize(new Dimension(200, 25));
	}

}
