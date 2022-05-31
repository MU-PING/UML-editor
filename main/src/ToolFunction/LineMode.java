package ToolFunction;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import UML.CanvasLine.Association;
import UML.CanvasObject.BasicObject;
import UML.CanvasObject.GraphObject;
import UML.CanvasObject.Port;

public abstract class LineMode extends Mode {

	private GraphObject startJPanel = null;
	private GraphObject endJPanel = null;

	private Point startPoint = null;
	private Point endPoint = null;
	
	protected Port startPort = null;
	protected Port endPort = null;

	public LineMode(String displayName) {
		super(displayName);
	}

	@Override
	public void action() {
		super.action();
		this.canvas.deleteDefaultAdapters();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		JPanel jpanelcheck1 = (JPanel) this.canvas.getComponentAt(e.getPoint());
		GraphObject jpanelcheck2;
		
		if (jpanelcheck1 != this.canvas) {
			jpanelcheck2 = (GraphObject) jpanelcheck1;
			if(jpanelcheck2.getPort_Flag()) {
				this.startJPanel = jpanelcheck2;
				this.startPoint = e.getPoint();
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		JPanel jpanelcheck1 = (JPanel) this.canvas.getComponentAt(e.getPoint());
		GraphObject jpanelcheck2;
		
		if (jpanelcheck1 != this.canvas) {
			jpanelcheck2 = (GraphObject) jpanelcheck1;
			if(jpanelcheck2.getPort_Flag() && jpanelcheck2!= this.startJPanel) {
				this.endJPanel  = jpanelcheck2;
				this.endPoint   = e.getPoint();
			}
		}

		if (this.startJPanel != null && this.endJPanel != null) {
			this.startPort = this.startJPanel.getNearestPort(this.startPoint);
			this.endPort = this.endJPanel.getNearestPort(this.endPoint);
			
			Association connection = this.generateConnection();
			
			this.startPort.setConnection(connection);
			this.endPort.setConnection(connection);
			this.canvas.addConnection(connection);
			
			this.startJPanel = null;
			this.endJPanel = null;
			this.startPoint = null;
			this.endPoint = null;
			this.startPort = null;
			this.endPort = null;
			
			this.canvas.repaint();
		}
	}
	public abstract Association generateConnection(); 
}
