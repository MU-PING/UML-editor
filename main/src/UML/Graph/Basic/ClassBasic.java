package UML.Graph.Basic;

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.*;

import UML.Canvas;

public class ClassBasic extends BasicObject{

	private JPanel attribute_field;
	private JPanel method_field;
	
	public ClassBasic(Canvas canvas, Point startPoint) {
		super(canvas, startPoint, new Dimension(230, 200));

		// ClassObject init
		this.setBorder(new TitledBorder("Class"));
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
