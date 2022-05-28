package UML;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import ToolFunction.Mode;
import UML.CanvasObject.GraphObject;
import UML.Listener.SelectModeAdapter;


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

	// ****** Strategy Design Pattern ******
	public final void setMode(Mode canvasMode) {
		this.mode = canvasMode;
	}
	// ****** ------------------------- ******
	
	public final void addGraphObject(GraphObject graphObject) {
		this.add(graphObject);
		this.setComponentZOrder(graphObject, 0);
		this.graphObjects.add(graphObject);
		System.out.printf("Add GraphObjects: %s \n", this.graphObjects.size());
		
		// repaint() -> update() -> paint()
		// paint()-> paintComponent()-> paintBorder()->paintChildren()
		this.repaint();
		this.validate();
	}
	
	// set select mode MouseAdapter
	public final void addSelectModeAdapters() {
		for(GraphObject currentObject: graphObjects) {
			currentObject.addSelectModeAdapter();
	    }
	}
	
	// delete select mode MouseAdapter
	public final void deleteSelectModeAdapters() {
		for(GraphObject currentObject: graphObjects) {
			currentObject.deleteSelectModeAdapter();
	    }
	}
	
	// set default MouseAdapter
	public final void addDefaultAdapters() {
		for(GraphObject currentObject: graphObjects) {
			currentObject.addDefaultAdapter();
	    }
	}
	
	// delete default mode MouseAdapter
	public final void deleteDefaultAdapters() {
		for(GraphObject currentObject: graphObjects) {
			currentObject.deleteDefaultAdapter();
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
		return new ArrayList<GraphObject>(this.selectedGraphObjects);
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
