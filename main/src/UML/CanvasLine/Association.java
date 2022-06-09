package UML.CanvasLine;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import UML.CanvasObject.Port;

public class Association {

	private JPanel canvas;
	private Port startPort;
	private Port endPort = null;
	protected Point startPoint;
	protected Point endPoint;
	private int check = 0;

	public Association(JPanel canvas, Port startPort) {
		this.canvas = canvas;
		this.startPort = startPort;
	}

	public void setEndPort(Port endPort) {
		this.endPort = endPort;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public void addCheck() {
		this.check += 1;
	}

	public void deleteCheck() {
		this.check -= 1;
	}

	public int check() {
		return this.check;
	}

	public void remove() {
		this.startPort.removeConnection(this);
		this.endPort.removeConnection(this);
	}

	public void setJPanel(JPanel canvas) {
		this.canvas = canvas;
	}

	public Graphics2D setGraphics2D(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));

		// rendering is done with antialiasing.
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// geometry should be left unmodified and rendered with sub-pixel accuracy.
		g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

		g2.setColor(new Color(120, 120, 120));

		return g2;

	}

	public void drawLine(Graphics g) {

		Graphics2D g2 = this.setGraphics2D(g);

		this.startPoint = SwingUtilities.convertPoint(this.startPort, this.startPort.getCenter(), this.canvas);
		if (this.endPort != null)
			this.endPoint = SwingUtilities.convertPoint(this.endPort, this.endPort.getCenter(), this.canvas);

		g2.drawLine(this.startPoint.x, this.startPoint.y, this.endPoint.x, this.endPoint.y);
	}
}
