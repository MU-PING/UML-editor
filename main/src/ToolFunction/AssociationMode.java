package ToolFunction;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import UML.Canvas;
import UML.CanvasObject.BasicObject;
import UML.CanvasObject.Connection;
import UML.CanvasObject.Port;

public class AssociationMode extends Mode {

	private BasicObject startJPanel = null;
	private BasicObject endJPanel = null;

	private Point startPoint = null;
	private Point endPoint = null;
	
	private Port startPort = null;
	private Port endPort = null;

	public AssociationMode(String displayName) {
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

	@Override
	public void mouseReleased(MouseEvent e) {
		JPanel getJpanel = (JPanel) this.canvas.getComponentAt(e.getPoint());

		if (getJpanel != this.canvas) {
			this.endJPanel = (BasicObject) getJpanel;
			this.endPoint = e.getPoint();
		}

		if (this.startJPanel != null & this.endJPanel != null) {
			this.startPort = this.startJPanel.getNearestPort(this.startPoint);
			this.endPort = this.endJPanel.getNearestPort(this.endPoint);
			
			Connection connection = new Connection(this.startPort, this.endPort);
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
}
