package Frame;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ToolFunction.Mode;
import UML.Canvas;
import UML.Graph.GraphObject;

public class CanvasTabPane extends JPanel implements ChangeListener{
	
	private ArrayList<Canvas> canvasPanels = new ArrayList<>();
	
	private Canvas canvasPanel;
	private JTabbedPane tabbedPane = new JTabbedPane();
	private int v;
	private int h;
	private Mode mode;
	
	public CanvasTabPane() {
		
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(238,233,233));
		this.v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		this.h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	
		this.tabbedPane.setFocusable(false);
		this.tabbedPane.addChangeListener(this);
		this.add(tabbedPane);
	}
	public void InitMode(Mode mode) {
		this.mode = mode;
		this.addTab("Untitled");
	}
	
	public void addTab(String name) {
		Canvas newCanvas = new Canvas(name);
		this.canvasPanels.add(newCanvas);
		JScrollPane scrollPane = new JScrollPane(newCanvas, this.v, this.h);
		this.tabbedPane.addTab(name, scrollPane);
	}
	
	public void setMode(Mode mode) {
		this.mode = mode;
		this.canvasPanel.setMode(this.mode);
	}

	public Canvas getCurrentCanvas() {
		return this.canvasPanel;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		JTabbedPane tb =(JTabbedPane)e.getSource();
	    int index = tb.getSelectedIndex();
	    this.canvasPanel = canvasPanels.get(index);
	    this.canvasPanel.setMode(this.mode);
	    this.mode.action();
	}
}
