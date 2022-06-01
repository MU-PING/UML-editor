package UML.CanvasLine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

import UML.Canvas;
import UML.CanvasObject.Port;

public class Composition extends Association {

	public Composition(Canvas canvas, Port port1, Port port2) {
		super(canvas, port1, port2);
	}

	public void drawHead(Graphics g) {
		int x1 = this.toPoint1.x;
		int y1 = this.toPoint1.y;
		int x2 = this.toPoint2.x;
		int y2 = this.toPoint2.y;
		int d = 10;
		int h = 10;

		Graphics2D g2 = (Graphics2D) g;

		int dx = x2 - x1, dy = y2 - y1;
		double D = Math.sqrt(dx * dx + dy * dy);
		double xm = D - d, xn = xm, ym = h, yn = -h, x;
		double sin = dy / D, cos = dx / D;

		x = xm * cos - ym * sin + x1;
		ym = xm * sin + ym * cos + y1;
		xm = x;

		x = xn * cos - yn * sin + x1;
		yn = xn * sin + yn * cos + y1;
		xn = x;

		double xo = xm + xn - x2;
		double yo = ym + yn - y2;

		Path2D.Double path = new Path2D.Double();
		path.moveTo(xo, yo);
		path.lineTo(xm, ym);
		path.lineTo(x2, y2);
		path.lineTo(xn, yn);
		path.closePath();

		g2.fill(path);
	}

}
