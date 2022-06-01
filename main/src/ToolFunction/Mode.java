package ToolFunction;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import Frame.CanvasTabPane_Singleton;
import UML.Canvas;

public class Mode implements ActionListener {

	private JToggleButton toggleButton = new JToggleButton();

	protected Mode(String name) {
		ImageIcon selectedImg = null, unselectedImg = null;
		// set Image
		try {
			selectedImg = new ImageIcon(ImageIO.read(this.getClass().getResource("Icon/" + name + "0.png")));
			unselectedImg = new ImageIcon(ImageIO.read(this.getClass().getResource("Icon/" + name + "1.png")));
		} catch (Exception ee) {
			System.out.println(ee);
		}

		// set Button
		this.toggleButton.setSelectedIcon(unselectedImg);
		this.toggleButton.setIcon(selectedImg);
		this.toggleButton.setFocusPainted(false);
		this.toggleButton.setToolTipText(name);
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
		CanvasTabPane_Singleton.getInstance().setMode(this);
		Canvas canvas = CanvasTabPane_Singleton.getInstance().getCurrentCanvas();
		canvas.addDefaultAdapters();
		canvas.deleteSelectModeAdapters();
		canvas.clearSelectedGraphObjects();
	}

	public void mouseClicked(MouseEvent e, Canvas canvas) {
	}

	public void mousePressed(MouseEvent e, Canvas canvas) {
	}

	public void mouseDragged(MouseEvent e, Canvas canvas) {
	}

	public void mouseReleased(MouseEvent e, Canvas canvas) {
	}

	public void mouseEntered(MouseEvent e, Canvas canvas) {
	}

	public void mouseExited(MouseEvent e, Canvas canvas) {
	}

	public void mouseMoved(MouseEvent e, Canvas canvas) {
	}

	public void paint(Graphics g) {
	}
}