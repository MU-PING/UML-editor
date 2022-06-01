package UML.Listener;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import UML.Canvas;
import UML.CanvasObject.GraphObject;

public class SelectModeAdapter extends MouseAdapter {

	protected Canvas canvas;

	public SelectModeAdapter(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GraphObject graphObject = (GraphObject) e.getSource();
		graphObject.setClickPoint(e.getPoint());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		GraphObject graphObject = (GraphObject) e.getSource();
		this.canvas.clearSelectedGraphObjects();
		this.canvas.addSelectedGraphObject(graphObject);
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		GraphObject graphObject = (GraphObject) e.getSource();

		Point clickPoint = graphObject.getClickPoint();

		int move_x = e.getPoint().x - clickPoint.x;
		int move_y = e.getPoint().y - clickPoint.y;

		graphObject.startPointTranslate(move_x, move_y);

		this.canvas.repaint();
	}
}
