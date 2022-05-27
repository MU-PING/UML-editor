package Frame;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
import ToolFunction.*;

public class ToolChooser extends JPanel{
	
	// Help Mode control Canvas
	private CanvasTabPane canvasTabPane = CanvasTabPane_Singleton.getInstance();
	
	// Button nanager
	private ButtonGroup listGroup = new ButtonGroup();
	
	// Polymorphism to manage Mode
	private ArrayList<Mode> modes = new ArrayList<Mode>();

	public ToolChooser() {
		SelectMode selectMode = new SelectMode("select");
		modes.add(selectMode);
		modes.add(new AssociationMode("association"));
		modes.add(new GeneralMode("general"));
		modes.add(new CompositionMode("composition"));
		modes.add(new ClassMode("class"));
		modes.add(new UsecaseMode("usecase"));
		
		this.setLayout(new GridLayout(modes.size(), 1));
		
		// initialize select mode
		selectMode.getButton().setSelected(true);
		this.canvasTabPane.initMode(selectMode);
		
		// init Button
		for (int i = 0; i < modes.size(); i++) {
			Mode mode = modes.get(i);
			this.add(mode.getButton());
			this.listGroup.add(mode.getButton());
		}
	}
}
