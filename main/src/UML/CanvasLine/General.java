package UML.CanvasLine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import UML.Canvas;
import UML.CanvasObject.Port;

public class General extends Association{

	public General(Canvas canvas, Port port1, Port port2) {
		super(canvas, port1, port2);
	}

	public void drawHead(Graphics g) {
		int x1 = this.toPoint1.x;
		int y1 = this.toPoint1.y;
		int x2 = this.toPoint2.x;
		int y2 = this.toPoint2.y;
		int d = 12;
		int h = 8;
		
		Graphics2D g2 = (Graphics2D)g;
		
		int dx = x2 - x1, dy = y2 - y1;
	    double D = Math.sqrt(dx*dx + dy*dy);
	    double xm = D - d, xn = xm, ym = h, yn = -h, x;
	    double sin = dy / D, cos = dx / D;

	    x = xm*cos - ym*sin + x1;
	    ym = xm*sin + ym*cos + y1;
	    xm = x;

	    x = xn*cos - yn*sin + x1;
	    yn = xn*sin + yn*cos + y1;
	    xn = x;

	    g2.draw(new Line2D.Double(x2, y2, xm, ym));
	    g2.draw(new Line2D.Double(x2, y2, xn, yn));
	    
	}

}
