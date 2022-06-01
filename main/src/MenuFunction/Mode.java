
package MenuFunction;

import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

public abstract class Mode implements ActionListener {

	protected JMenuItem menuItem;

	protected Mode(String name) {

		try {
			this.menuItem = new JMenuItem(name,
					new ImageIcon(ImageIO.read(this.getClass().getResource("Icon/" + name + ".png"))));
			this.menuItem.addActionListener(this);
		} catch (Exception ee) {
			System.out.println(ee);
		}
	}

	// memberMethod cant Override
	public final JMenuItem getItem() {
		return this.menuItem;
	}

}
