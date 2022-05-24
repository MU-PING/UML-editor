package UML.Graph.Basic;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import UML.Canvas;
import UML.Graph.GraphObject;
import UML.Graph.MouseListener.BasicMouse;

public class BasicObject extends GraphObject{

	protected Font displayFont = new Font("Comic Sans MS", Font.BOLD, 18);
	protected JLabel title = new JLabel("Untitled");
	protected JPanel classTitle = new JPanel();
	protected ArrayList<Port> ports = new ArrayList<Port>();
	
	protected BasicObject(Canvas canvas, Point startPoint, Dimension size) {
		super(canvas, new Rectangle(startPoint, size), new Color(238,243,203));

		this.mouseAdapter = new BasicMouse(canvas, this);
		
		// title
		this.title.setFont(displayFont);
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.classTitle.setLayout(new BorderLayout());
		this.classTitle.setBackground(new Color(255,185,15));
		this.classTitle.add(this.title, BorderLayout.CENTER);
		
		// superlayout
		this.setBackground(this.unselectColor);
		this.setLayout(new BorderLayout());
	}

	public void setTitle(String title) {
		this.title.setText(title);
	}
	
	public void setPort(Port port) {
		ports.add(port);
	}
	
	public ArrayList<Port> getPort() {
		return ports;
	}
	
	public void beSelected() {
		super.beSelected();
		for(Port currentPort : ports){
			currentPort.setVisible(true);
			this.canvas.setComponentZOrder(currentPort, 0);
		}
	}
	
	public void beUnSelected() {
		super.beUnSelected();
		for(Port currentPort : ports){
			currentPort.setVisible(false);
		}
	}
	
	@Override
	public void clickUnGroup() {
		JOptionPane.showMessageDialog(this, "Composite object has no name", "Warning", JOptionPane.ERROR_MESSAGE);
	}
	
	@Override
	public void clickChangeName() {
		String input = JOptionPane.showInputDialog(this, "Name", "Change Object Name", JOptionPane.INFORMATION_MESSAGE);
		if(input!=null) {this.setTitle(input);}
	}
	
}
