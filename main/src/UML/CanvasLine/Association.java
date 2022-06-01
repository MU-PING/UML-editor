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
	private Port port1;
	private Port port2;
	protected Point toPoint1;
	protected Point toPoint2;
	private int check = 0;

	public Association(JPanel canvas, Port port1, Port port2) {
		this.canvas = canvas;
		this.port1 = port1;
		this.port2 = port2;
	}

	public Port getPort1() {
		return this.port1;
	}

	public Port getPort2() {
		return this.port2;
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
		this.port1.removeConnection(this);
		this.port2.removeConnection(this);
	}

	public void setJPanel(JPanel canvas) {
		this.canvas = canvas;
	}

	public void drawLine(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));

		// rendering is done with antialiasing.
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// geometry should be left unmodified and rendered with sub-pixel accuracy.
		g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

		g2.setColor(new Color(120, 120, 120));

		this.toPoint1 = SwingUtilities.convertPoint(this.port1, this.port1.getCenter(), this.canvas);
		this.toPoint2 = SwingUtilities.convertPoint(this.port2, this.port2.getCenter(), this.canvas);

		g2.drawLine(this.toPoint1.x, this.toPoint1.y, this.toPoint2.x, this.toPoint2.y);
		this.drawHead(g2);
	}

	public void drawHead(Graphics g) {
	}
}
