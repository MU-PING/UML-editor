package UML.CanvasObject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class Port extends JPanel{

	private Point startPoint;
	private Dimension size;
	private Rectangle pointSize;
	
	public Port(Point startPoint, int portsize) {
		this.startPoint = startPoint;
		this.size = new Dimension(portsize, portsize);
		this.pointSize = new Rectangle(this.startPoint, this.size);
		
		// layout
		this.setLayout(null);
		this.setBackground(new Color(156, 156, 156));
		this.setVisible(false);
		
		// setBounds work even if setting layout to BorderLayout
		this.setBounds(this.pointSize);
	}
}
