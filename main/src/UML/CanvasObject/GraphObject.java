package UML.CanvasObject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import UML.Canvas;
import UML.Listener.SelectModeAdapter;

public abstract class GraphObject extends JPanel implements MouseListener {

	protected Canvas canvas;
	protected Rectangle pointSize;
	protected Point startPoint;
	protected Dimension size;
	protected Point endPoint;
	protected Color selectColor = new Color(255, 246, 143);
	protected Color unselectColor;

	protected MouseAdapter selectModeAdapter;
	protected boolean selectModeAdapter_flag = false;
	protected boolean defaultAdapter_flag = false;
	
	private Point clickPoint;

	public GraphObject(Canvas canvas, Rectangle pointSize, Color unselectColor) {
		this.canvas = canvas;
		this.pointSize = pointSize;
		this.startPoint = this.pointSize.getLocation();
		this.size = this.pointSize.getSize();
		this.endPoint = new Point(this.startPoint);
		this.endPoint.translate(this.size.width, this.size.height);
		this.unselectColor = unselectColor;
		this.selectModeAdapter = new SelectModeAdapter(this.canvas);

		this.addMouseListener(this);
		this.defaultAdapter_flag = true;
		
		this.setBounds(pointSize);
	}

	public void addSelectModeAdapter() {
		if (!this.selectModeAdapter_flag) {
			this.selectModeAdapter_flag = true;
			this.addMouseListener(this.selectModeAdapter);
			this.addMouseMotionListener(this.selectModeAdapter);
		}
	}

	public void deleteSelectModeAdapter() {
		if (this.selectModeAdapter_flag) {
			this.selectModeAdapter_flag = false;
			this.removeMouseListener(this.selectModeAdapter);
			this.removeMouseMotionListener(this.selectModeAdapter);
		}
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
	public void clickUnGroup() {
	}

	public void clickChangeName() {
	}

	public void addDefaultAdapter() {
	}

	public void deleteDefaultAdapter() {
	}
	
	// ****** ------------------------- ******

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
