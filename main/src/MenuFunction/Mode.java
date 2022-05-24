package MenuFunction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem ;
import javax.swing.JToggleButton;

import Frame.CanvasTabPane;

public abstract class Mode implements ActionListener{
	private String displayName;
	protected CanvasTabPane canvasTabPane;
	protected JMenuItem menuItem;
	
	protected Mode(String name, CanvasTabPane canvasTabPane){
		this.displayName = name;
		this.canvasTabPane = canvasTabPane;
		
		try {
			this.menuItem = new JMenuItem(this.displayName, new ImageIcon(ImageIO.read(this.getClass().getResource("Icon/" + this.displayName + ".png"))));
			this.menuItem.addActionListener(this);
		}
		catch (Exception ee) {
			System.out.println(ee);
		}	
	}
	// memberMethod cant Override
	public final JMenuItem getItem() {
		return this.menuItem;
	}

}
