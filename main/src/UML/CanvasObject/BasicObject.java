package UML.CanvasObject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import UML.Canvas;
import UML.Listener.ObjectMove;

public class BasicObject extends GraphObject{

	protected JLabel title = new JLabel("Untitled");
	protected JPanel classTitle = new JPanel();
	protected Font displayFont = new Font("Comic Sans MS", Font.BOLD, 14);
	protected ArrayList<Port> ports = new ArrayList<Port>();
	protected int portSize = 8;
	
	protected BasicObject(Canvas canvas, Point startPoint, Dimension size) {
		super(canvas, new Rectangle(startPoint, size), new Color(238,243,203));

		// superlayout
		this.setBackground(this.unselectColor);
		this.setLayout(new BorderLayout());
				
		// title
		this.title.setFont(displayFont);
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.classTitle.setLayout(new BorderLayout());
		this.classTitle.setBackground(new Color(255,185,15));
		this.classTitle.add(this.title, BorderLayout.CENTER);
		
		// initialize port
		int x, y;

			// top port
		x = (this.size.width - this.portSize)/2;
		y = 0;
		this.setPort(x, y);

			// left port
		x = 0;
		y = (this.size.height - this.portSize)/2;
		this.setPort(x, y);
		
			// right port
		x = this.size.width - this.portSize;
		y = (this.size.height - this.portSize)/2;
		this.setPort(x, y);
		
			// bottom port
		x = (this.size.width - this.portSize)/2;
		y = this.size.height - this.portSize;
		this.setPort(x, y);
	}

	public void setTitle(String title) {
		this.title.setText(title);
	}
	
	public void setPort(int x, int y) {
		Port port = new Port(new Point(x, y), portSize);
		this.ports.add(port);
		
		// if there is no constraints(NORTH..) in BorderLayout, the default will be in the center
		// but if the center is replaced by other component, the original component will be layouted by setbounds 
		this.add(port);
	}

	@Override
	public void beSelected() {
		super.beSelected();
		for(Port currentPort : ports){
			currentPort.setVisible(true);
		}
	}
	
	@Override
	public void beUnSelected() {
		super.beUnSelected();
		for(Port currentPort : ports){
			currentPort.setVisible(false);
		}
	}

	@Override
	public void clickChangeName() {
		String input = JOptionPane.showInputDialog(this, "Name", "Change Object Name", JOptionPane.INFORMATION_MESSAGE);
		if(input!=null) {this.setTitle(input);}
	}
	
}
