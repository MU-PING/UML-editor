package UML.CanvasObject;

public class Connection {
	
	private Port port1;
	private Port port2;
	public int check = 0;
	
	public Connection(Port port1, Port port2) {
		this.port1 = port1;
		this.port2 = port2;
	}
	
	public Port getPort1() {
		return this.port1;
	}
	
	public Port getPort2() {
		return this.port2;
	}
	
	public void addCheck() {
		this.check += 1;
	}
	
	public void deleteCheck() {
		this.check -= 1;
	}
	
	public int check() {
		return this.check;
	}
	
	public void remove() {
		this.port1.removeConnection(this);
		this.port2.removeConnection(this);
	}
	
}
