package objects;

public class Alimento {
	
	private String name;
	private boolean urgent, loop;
	
	public Alimento(String n, boolean u, boolean l) {
		
		name = n;
		urgent = u;
		loop = l;
	}
	
	public Alimento() {
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}

}
