package ToolFunction;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import UML.CanvasLine.Association;
import UML.CanvasObject.BasicObject;
import UML.CanvasObject.Port;

public abstract class LineMode extends Mode {

	private BasicObject startJPanel = null;
	private BasicObject endJPanel = null;

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
		JPanel getJpanel = (JPanel) this.canvas.getComponentAt(e.getPoint());

		if (getJpanel != this.canvas) {
			this.startJPanel = (BasicObject) getJpanel;
			this.startPoint = e.getPoint();
		}
	}

	public void mouseReleased(MouseEvent e) {
		JPanel getJpanel = (JPanel) this.canvas.getComponentAt(e.getPoint());

		if (getJpanel != this.canvas & getJpanel != this.startJPanel) {
			this.endJPanel = (BasicObject) getJpanel;
			this.endPoint = e.getPoint();
		}

		if (this.startJPanel != null & this.endJPanel != null) {
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
