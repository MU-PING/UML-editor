package UML.CanvasObject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

import UML.Canvas;

public abstract class GraphObject extends JPanel implements MouseListener {

	protected Canvas canvas;
	protected Rectangle pointSize;
	protected Point startPoint;
	protected Dimension size;
	protected Point endPoint;
	protected Color selectColor;
	protected Color unselectColor;
	protected MouseAdapter move;
	private Point clickPoint;

	public GraphObject(Canvas canvas, Rectangle pointSize, Color unselectColor) {
		this.canvas = canvas;
		this.pointSize = pointSize;
		this.startPoint = this.pointSize.getLocation();
		this.size = this.pointSize.getSize();
		this.endPoint = new Point(this.startPoint);
		this.endPoint.translate(this.size.width, this.size.height);
		this.selectColor = new Color(255, 246, 143);
		this.unselectColor = unselectColor;

		this.addMouseListener(this);
		this.setBounds(pointSize);
	}

	public void addMouseAdapter() {
		this.addMouseListener(this.move);
		this.addMouseMotionListener(this.move);
	}

	public void deleteMouseAdapter() {
		this.removeMouseListener(this.move);
		this.removeMouseMotionListener(this.move);
	}

	public void setClickPoint(Point clickPoint) {
		this.clickPoint = clickPoint;
	}

	public Point getClickPoint() {
		return this.clickPoint;
	}

	public void setStartPoint(Point p) {
		this.startPoint.setLocation(p);
		this.pointSize.setLocation(p);
		this.endPoint = new Point(this.startPoint);
		this.endPoint.translate(this.size.width, this.size.height);
		this.setBounds(this.pointSize);
	}

	public Point getStartPoint() {
		return this.startPoint;
	}

	public void startPointTranslate(int movex, int movey) {
		this.startPoint.translate(movex, movey);
		this.pointSize.setLocation(this.startPoint);
		this.endPoint = new Point(this.startPoint);
		this.endPoint.translate(this.size.width, this.size.height);
		this.setBounds(this.pointSize);
	}

	public Dimension getDimension() {
		return this.size;
	}

	public Point getEndPoint() {
		return this.endPoint;
	}

	public Rectangle getPointSize() {
		return this.pointSize;
	}

	public void beSelected() {
		this.setBackground(this.selectColor);
	}

	public void beUnSelected() {
		this.setBackground(this.unselectColor);
	}

	// ****** Composite Design Pattern ******
	public abstract void clickUnGroup();

	public abstract void clickChangeName();

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
