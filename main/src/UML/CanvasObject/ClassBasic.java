package UML.CanvasObject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import UML.Canvas;

public class ClassBasic extends BasicObject{

	private JPanel attribute_field;
	private JPanel method_field;
	
	public ClassBasic(Canvas canvas, Point startPoint) {
		super(canvas, startPoint, new Dimension(160, 140));

		// ClassObject init
		this.setBorder(new TitledBorder("Class"));
		
		// --Title--
		this.add(this.classTitle, BorderLayout.NORTH);
		
		// --Attribute Field--
		attribute_field = new JPanel();
		attribute_field.setLayout(new BorderLayout());
		attribute_field.setBackground(new Color(255,253,208));
		JLabel attribute_label = new JLabel("--Attribute Field--");
		attribute_label.setHorizontalAlignment(JLabel.CENTER);
		attribute_label.setFont(this.displayFont);
		attribute_field.add(attribute_label, BorderLayout.NORTH);
		this.add(attribute_field, BorderLayout.CENTER);
		
		// --Method Field--
		method_field = new JPanel();
		method_field.setLayout(new BorderLayout());
		method_field.setBackground(new Color(245,245,220));
		JLabel method_label = new JLabel("--Method Field--");
		method_label.setHorizontalAlignment(JLabel.CENTER);
		method_label.setFont(this.displayFont);
		method_field.add(method_label, BorderLayout.NORTH);
		this.add(method_field, BorderLayout.SOUTH);
	}
	
}
