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
import UML.CanvasObject.Port;

public class AssociationMode extends Mode {

	private BasicObject startJPanel = null;
	private BasicObject endJPanel = null;

	private Point startPoint = null;
	private Point endPoint = null;

	public AssociationMode(String displayName) {
		super(displayName);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);

		Canvas canvas = this.canvasTabPane.getCurrentCanvas();
		canvas.deleteDefaultAdapters();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Canvas canvas = this.canvasTabPane.getCurrentCanvas();
		JPanel getJpanel = (JPanel) canvas.getComponentAt(e.getPoint());

		if (getJpanel != canvas) {
			this.startJPanel = (BasicObject) getJpanel;
			this.startPoint = e.getPoint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Canvas canvas = this.canvasTabPane.getCurrentCanvas();
		JPanel getJpanel = (JPanel) canvas.getComponentAt(e.getPoint());

		if (getJpanel != canvas) {
			this.endJPanel = (BasicObject) getJpanel;
			this.endPoint = e.getPoint();
		}

		if (this.startJPanel != null & this.endJPanel != null) {
			this.startPoint = this.startJPanel.getNearestPort(this.startPoint);
			this.endPoint = this.endJPanel.getNearestPort(this.endPoint);
			canvas.repaint();
		}

	}
	
    public void paint(Graphics g) {
    	Graphics2D g2 = (Graphics2D)g;
    	g2.setStroke(new BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));
    	
    	// Antaliasing
    	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.black);
		g2.drawLine(this.startPoint.x, this.startPoint.y, this.endPoint.x, this.endPoint.y);
	}
}
