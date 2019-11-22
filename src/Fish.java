
public class Fish {
	
	private int position;
	private boolean direction;

	
	public Fish(int position, boolean direction) {
		super();
		this.position = position;
		this.direction = direction;
	}


	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		this.position = position;
	}

	// true = nach rechts, false = nach links
	public boolean getDirection() {
		return direction;
	}


	public void setDirection(boolean direction) {
		this.direction = direction;
	}
	
	

}
