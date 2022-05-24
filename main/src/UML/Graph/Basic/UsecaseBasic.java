package UML.Graph.Basic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import UML.Canvas;

public class UsecaseBasic extends BasicObject{

	public UsecaseBasic(Canvas canvas, Point startPoint) {
		super(canvas, startPoint, new Dimension(180, 80));

		// UsecaseObject init
		this.setBorder(new TitledBorder("Usecase"));
		this.add(this.classTitle, BorderLayout.CENTER);

	}
}

	// Oval version
	//@Override
	//public void GUI() {
	//	// ClassObject init
	//	
	//	TitledBorder titledBorder = new TitledBorder("Usecase");
	//	titledBorder.setBorder(new EmptyBorder(0,0,0,0));
	//	this.setLayout(null);
	//	this.setBorder(titledBorder);
	//	this.classTitle.setBounds(75, 50, 150, 30);
	//	this.add(this.classTitle);
	//}
	//
	//public void paintComponent(Graphics g) {
	//	g.setColor(new Color(238,233,233));
	//	g.fillOval(5, 20, this.getWidth()-10, this.getHeight()-25); 
	//}