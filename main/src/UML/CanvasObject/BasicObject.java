package UML.CanvasObject;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import UML.Canvas;
import UML.MouseObject;

public class BasicObject extends GraphObject{

	protected Font displayFont = new Font("Comic Sans MS", Font.BOLD, 18);
	protected JLabel title = new JLabel("Untitled");
	protected JPanel classTitle = new JPanel();
	protected ArrayList<Port> ports = new ArrayList<Port>();
	protected int portSize = 10;
	
	protected BasicObject(Canvas canvas, Point startPoint, Dimension size) {
		super(canvas, new Rectangle(startPoint, size), new Color(238,243,203));

		this.mouseAdapter = new MouseObject(canvas, this);
		
		// superlayout
		this.setBackground(this.unselectColor);
		this.setLayout(new BorderLayout());
				
		// title
		this.title.setFont(displayFont);
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.classTitle.setLayout(new BorderLayout());
		this.classTitle.setBackground(new Color(255,185,15));
		this.classTitle.add(this.title, BorderLayout.CENTER);
		this.add(this.classTitle, BorderLayout.NORTH);
		
		// initialize port
		int x, y;
		int startx = this.startPoint.x;
		int starty = this.startPoint.y;
		int width = this.size.width;
		int height = this.size.height;
		
			// top port
		x = startx + (width - this.portSize)/2;
		y = starty - this.portSize;
		this.setPort(x, y);
		
			// left port
		x = startx - this.portSize;
		y = starty + (height - this.portSize)/2;
		this.setPort(x, y);
		
			// right port
		x = startx + width;
		y = starty + (height - this.portSize)/2;
		this.setPort(x, y);

			// bottom port
		x = startx + (width - this.portSize)/2;
		y = starty + height;
		this.setPort(x, y);
	}

	public void setTitle(String title) {
		this.title.setText(title);
	}
	
	public void setPort(int x, int y) {
		Port port = new Port(new Point(x, y), portSize);
		this.ports.add(port);
		this.canvas.add(port);
		this.canvas.setComponentZOrder(port, 0);
	}
	
	@Override
	public void setStartPoint(Point p) {
		super.setStartPoint(p);
		
		for(Port port : ports) {
			
		}
		
	}
	
	@Override
	public void startPointTranslate(int movex, int movey) {
		super.startPointTranslate(movex, movey);
		
		
	}
	
	@Override
	public void beSelected() {
		super.beSelected();
		for(Port currentPort : ports){
			currentPort.setVisible(true);
			this.canvas.setComponentZOrder(currentPort, 0);
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
	public void clickUnGroup() {
		JOptionPane.showMessageDialog(this, "Composite object has no name", "Warning", JOptionPane.ERROR_MESSAGE);
	}
	
	@Override
	public void clickChangeName() {
		String input = JOptionPane.showInputDialog(this, "Name", "Change Object Name", JOptionPane.INFORMATION_MESSAGE);
		if(input!=null) {this.setTitle(input);}
	}
	
}
