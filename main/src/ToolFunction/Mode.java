package ToolFunction;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import Frame.CanvasTabPane;
import UML.Canvas;
import UML.CanvasObject.BasicObject;

import javax.imageio.ImageIO;

public class Mode implements ActionListener{
	
	private String displayName;
	protected CanvasTabPane canvasTabPane;
	private JToggleButton toggleButton;
	private ImageIcon selectedImg, unselectedImg;

	protected Mode(String name, CanvasTabPane canvasTabPane){
		
		this.displayName = name;
		this.canvasTabPane = canvasTabPane;
		this.toggleButton = new JToggleButton();
		
		// set Image
		try {
			this.selectedImg = new ImageIcon(ImageIO.read(this.getClass().getResource("Icon/" + this.displayName + "0.png")));
			this.unselectedImg = new ImageIcon(ImageIO.read(this.getClass().getResource("Icon/" + this.displayName + "1.png")));
		}
		catch (Exception ee) {
			System.out.println(ee);
		}
		
		// set Button
		this.toggleButton.setSelectedIcon(this.unselectedImg);
		this.toggleButton.setIcon(this.selectedImg);
		this.toggleButton.setFocusPainted(false);
		this.toggleButton.setToolTipText(this.displayName);
		this.toggleButton.addActionListener(this);
	}
	
	// Member Method cant Override
	public final JToggleButton getButton() {
		return this.toggleButton;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.action();
	}
	
	public void action() {
		Canvas canvas = this.canvasTabPane.getCurrentCanvas();
		this.canvasTabPane.setMode(this);
		canvas.clearALLMouseAdapter();
		canvas.clearSelectedGraphObjects();
	}

	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	public void paint(Graphics g) {}
}