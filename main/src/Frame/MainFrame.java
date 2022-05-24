package Frame;

// java GUI component
import javax.swing.*;
import java.awt.*;

// setting java GUI style
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class MainFrame extends JFrame{
	
	public MainFrame() {
		
		// MainFrame setting
		this.setTitle("MUML 1.0");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1920, 960);
		this.setLayout(new BorderLayout());
		
		// CanvasTabPane
		CanvasTabPane canvasTabPane = new CanvasTabPane();
		
		// MenuChooser
		MenuChooser menuChooser = new MenuChooser(canvasTabPane);
		this.setJMenuBar(menuChooser);
		
		// ToolChooser and 
		ToolChooser toolChooser = new ToolChooser(canvasTabPane);
		
		this.add(toolChooser, BorderLayout.WEST);
		this.add(canvasTabPane, BorderLayout.CENTER);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		try {
			// print all style that we can choose
			UIManager.LookAndFeelInfo[] info = UIManager.getInstalledLookAndFeels();  
			for (LookAndFeelInfo lookAndFeelInfo : info) {  
			    System.out.println("name:" + lookAndFeelInfo.getName());  
			    System.out.println("class:" + lookAndFeelInfo.getClassName());  
			}
		    // select style and font size
		    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception e) {
			System.out.print("setting style error");
		}
		
		new MainFrame();
	}
}
