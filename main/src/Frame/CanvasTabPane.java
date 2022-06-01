package Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ToolFunction.Mode;
import UML.Canvas;

public class CanvasTabPane extends JPanel implements ChangeListener {

	private ArrayList<Canvas> canvasPanels = new ArrayList<>();

	private Canvas canvasPanel;
	private JTabbedPane tabbedPane = new JTabbedPane();
	private int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
	private int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	private Mode mode;

	public CanvasTabPane() {

		this.setLayout(new BorderLayout());
		this.setBackground(new Color(238, 233, 233));

		this.tabbedPane.setFocusable(false);
		this.tabbedPane.addChangeListener(this);
		this.add(tabbedPane);
	}

	public void setMode(Mode mode) {
		this.mode = mode;
		this.canvasPanel.setMode(this.mode);
	}

	public Canvas getCurrentCanvas() {
		return this.canvasPanel;
	}

	public void initCanvas(Mode mode) {
		this.mode = mode;
		this.addTab("Untitled");
	}

	public void addTab(String name) {
		Canvas newCanvas = new Canvas(name);
		this.canvasPanels.add(newCanvas);
		JScrollPane scrollPane = new JScrollPane(newCanvas, this.v, this.h);
		this.tabbedPane.addTab(name, scrollPane);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JTabbedPane tb = (JTabbedPane) e.getSource();
		this.canvasPanel = canvasPanels.get(tb.getSelectedIndex());
		this.canvasPanel.setMode(this.mode);
		this.mode.action();
	}
}
