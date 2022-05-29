package ToolFunction;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import Frame.CanvasTabPane;
import Frame.CanvasTabPane_Singleton;
import UML.Canvas;

public class Mode implements ActionListener{
	
	private String displayName;
	protected CanvasTabPane canvasTabPane = CanvasTabPane_Singleton.getInstance();
	protected Canvas canvas;
	private JToggleButton toggleButton = new JToggleButton();
	private ImageIcon selectedImg, unselectedImg;

	protected Mode(String name){
		
		this.displayName = name;
		
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
		this.canvasTabPane.setMode(this);
		this.canvas = this.canvasTabPane.getCurrentCanvas();
		this.canvas.addDefaultAdapters();
		this.canvas.deleteSelectModeAdapters();
		this.canvas.clearSelectedGraphObjects();
	}

	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	public void paint(Graphics g) {}
}