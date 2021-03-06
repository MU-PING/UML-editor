package ToolFunction;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import Frame.CanvasTabPane_Singleton;
import UML.Canvas;

public class SelectMode extends Mode {

	private Point startPoint = null;
	private Point endPoint = null;

	public SelectMode(String displayName) {
		super(displayName);
	}

	@Override
	public void action() {
		super.action();
		CanvasTabPane_Singleton.getInstance().getCurrentCanvas().addSelectModeAdapters();
	}

	@Override
	public void mousePressed(MouseEvent e, Canvas canvas) {
		canvas.clearSelectedGraphObjects();
		this.startPoint = e.getPoint();
		canvas.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e, Canvas canvas) {
		this.endPoint = e.getPoint();
		canvas.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e, Canvas canvas) {

		if (startPoint != null && endPoint != null) {
			int mnx, mny;
			int mxx, mxy;
			mnx = Math.min(this.startPoint.x, this.endPoint.x);
			mny = Math.min(this.startPoint.y, this.endPoint.y);
			mxx = Math.max(this.startPoint.x, this.endPoint.x);
			mxy = Math.max(this.startPoint.y, this.endPoint.y);

			// record the selected area
			Rectangle area = new Rectangle(mnx, mny, mxx - mnx, mxy - mny);
			canvas.addSelectedGraphObjects(area);

		}
		this.startPoint = null;
		this.endPoint = null;
		canvas.repaint();
	}

	@Override
	public void paint(Graphics g) {
		if (this.startPoint != null && this.endPoint != null) {
			int mnx, mny;
			int mxx, mxy;

			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.BLACK);
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
			mnx = Math.min(this.startPoint.x, this.endPoint.x);
			mny = Math.min(this.startPoint.y, this.endPoint.y);
			mxx = Math.max(this.startPoint.x, this.endPoint.x);
			mxy = Math.max(this.startPoint.y, this.endPoint.y);

			g2d.fillRect(mnx, mny, mxx - mnx, mxy - mny);
		}

	}
}
