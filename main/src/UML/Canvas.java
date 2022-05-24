package UML;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ToolFunction.Mode;
import UML.Canvas;
import UML.Graph.GraphObject;

import java.util.ArrayList;


public class Canvas extends JPanel implements MouseListener, MouseMotionListener {
	
	private ArrayList<GraphObject> graphObjects = new ArrayList<>();
	private ArrayList<GraphObject> selectedGraphObjects = new ArrayList<>();
	
	private Mode mode;
	
	public Canvas(String Name) {
		this.setName(Name);
		this.setLayout(null);
		this.setBackground(new Color(255,255,255));
		this.setPreferredSize(new Dimension(3840, 2160));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	// Member Method cant Override
	public final void setMode(Mode canvasMode) {
		this.mode = canvasMode;
	}
	
	public final void addGraphObject(GraphObject graphObject) {
		this.add(graphObject);
		this.setComponentZOrder(graphObject, 0);
		this.graphObjects.add(graphObject);
		System.out.printf("Add GraphObjects: %s \n", this.graphObjects.size());
		
		this.repaint();
		this.validate();
	}
	
	// repaint() -> update() -> paint()
	// paint()-> paintComponent()-> paintBorder()->paintChildren()
	
	// set select mode MouseAdapter
	public final void setALLMouseAdapter() {
		for(GraphObject currentObject: graphObjects) {
			currentObject.addSelectMouseAdapter();
	    }
	}
	
	// clear select mode MouseAdapter
	public final void clearALLMouseAdapter() {
		for(GraphObject currentObject: graphObjects) {
			currentObject.deleteSelectMouseAdapter();
	    }
	}
	
	// select one object
	public final void addSelectedGraphObject(GraphObject graphObject) {
		graphObject.beSelected();
		this.selectedGraphObjects.add(graphObject);
		System.out.printf("Add SelectedGraphObjects: %s \n", this.selectedGraphObjects.size());
		this.setComponentZOrder(graphObject, 0);
		this.repaint();
	}
	
	// select more objects
	public final void addSelectedGraphObjects(Rectangle area) {
		
		for(GraphObject currentObject: graphObjects) {
			Rectangle r = currentObject.getPointSize();
			
			if(area.contains(r)) {
				this.addSelectedGraphObject(currentObject);
			}
		}
	}
		
	// remove grouped objects
	public final void groupRemove() {
		
		for(GraphObject currentObject: this.selectedGraphObjects) {
			this.graphObjects.remove(currentObject);
			System.out.printf("Remove GraphObjects: %s \n", this.graphObjects.size());
	    }
	}
	
	public final void ungroupRemove(GraphObject graphObject) {
		
		this.remove(graphObject);
		this.graphObjects.remove(graphObject);
		System.out.printf("Remove GraphObjects: %s \n", this.graphObjects.size());
		this.repaint();
		this.validate();
	} 
	
	// clear selected objects
	public final void clearSelectedGraphObjects() {
		for(GraphObject currentObject: this.selectedGraphObjects) {
			currentObject.beUnSelected();
	    }
		this.selectedGraphObjects.clear();
	} 
	
	public final ArrayList<GraphObject> getSelectedGraphObjects() {
		return new ArrayList<>(this.selectedGraphObjects);
	}
	
	// MouseListener
	@Override
	public void mouseClicked(MouseEvent e) {
		this.mode.mouseClicked(e);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		this.mode.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.mode.mouseReleased(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.mode.mouseEntered(e);
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		this.mode.mouseExited(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.mode.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.mode.mouseMoved(e);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		this.mode.paint(g);
	}
}
