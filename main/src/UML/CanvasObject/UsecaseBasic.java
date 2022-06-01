package UML.CanvasObject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.border.TitledBorder;

import UML.Canvas;

public class UsecaseBasic extends BasicObject {

	public UsecaseBasic(Canvas canvas, Point startPoint) {
		super(canvas, startPoint, new Dimension(140, 70));

		// UsecaseObject init
		this.setBorder(new TitledBorder("Usecase"));

		// --Title--
		this.add(this.classTitle, BorderLayout.CENTER);
	}
}