package Frame;

// ****** Singleton Design Pattern(Greed Singleton)******
public class CanvasTabPane_Singleton {
	
	private static CanvasTabPane canvasTabPane = new CanvasTabPane();
	
	private CanvasTabPane_Singleton(){}
	
    public static CanvasTabPane getInstance(){
        return canvasTabPane;
    }
}
