package ToolFunction;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import Frame.CanvasTabPane_Singleton;
import UML.Canvas;
import UML.CanvasLine.Association;
import UML.CanvasObject.GraphObject;
import UML.CanvasObject.Port;

public abstract class LineMode extends Mode {

	private Association association = null;

	private GraphObject startJPanel = null;
	private Port startPort = null;

	public LineMode(String displayName) {
		super(displayName);
	}

	@Override
	public void action() {
		super.action();
		CanvasTabPane_Singleton.getInstance().getCurrentCanvas().deleteDefaultAdapters();
	}

	@Override
	public void mousePressed(MouseEvent e, Canvas canvas) {
		JPanel jpanelcheck1 = (JPanel) canvas.getComponentAt(e.getPoint());
		GraphObject jpanelcheck2;

		if (jpanelcheck1 != canvas) {
			jpanelcheck2 = (GraphObject) jpanelcheck1;
			if (jpanelcheck2.getPort_Flag()) {
				this.startJPanel = jpanelcheck2;
				this.startPort = this.startJPanel.getNearestPort(e.getPoint());
				this.association = this.generateConnection(canvas, this.startPort);
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e, Canvas canvas) {

		if (this.association != null) {
			this.association.setEndPoint(e.getPoint());
			canvas.repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e, Canvas canvas) {
		JPanel jpanelcheck1 = (JPanel) canvas.getComponentAt(e.getPoint());
		GraphObject jpanelcheck2;

		if (this.association != null) {
			if (jpanelcheck1 != canvas) {
				jpanelcheck2 = (GraphObject) jpanelcheck1;
				if (jpanelcheck2.getPort_Flag() && jpanelcheck2 != this.startJPanel) {
					GraphObject endJPanel = jpanelcheck2;
					Port endPort = endJPanel.getNearestPort(e.getPoint());

					this.association.setEndPort(endPort);
					this.startPort.setConnection(this.association);
					endPort.setConnection(this.association);
					canvas.addConnection(this.association);
				}
			}

		}
		this.association = null;
		this.startJPanel = null;
		this.startPort = null;

		canvas.repaint();
	}

	public abstract Association generateConnection(Canvas canvas, Port startPort);

	@Override
	public void paint(Graphics g) {

		if (this.association != null) {
			this.association.drawLine(g);
		}
	}
}
