public class Aquarium {

	private int numOfFishes;
	private int width;
	private Fish[] fishes;
	private Lane[] lanes; 

	//Test-Konstruktor mit 4 Fischen im 42er Aquarium:
	public Aquarium() {
		super();
		this.numOfFishes = 4;
		this.width = 42;
		this.fishes = new Fish[this.getNumOfFishes()];
		this.lanes = new Lane[this.getNumOfFishes()+1];
		
		fishes[0] = new Fish(5, true); //ToDo: initiale Zufallsposition
		fishes[1] = new Fish(25, false);
		fishes[2] = new Fish(10, false);
		fishes[3] = new Fish(35, true);
		
		lanes[0] = new Lane(this.getWidth(), null); //Aquariumboden
		lanes[1] = new Lane(this.getWidth(), getFishes()[0]);
		lanes[2] = new Lane(this.getWidth(), getFishes()[1]);
		lanes[3] = new Lane(this.getWidth(), getFishes()[2]);
		lanes[4] = new Lane(this.getWidth(), getFishes()[3]);
	}
	

	public Aquarium(int numOfFishes, int width) {
		super();
		this.numOfFishes = numOfFishes;
		this.width = width;
		this.fishes = new Fish[numOfFishes];
		this.lanes = new Lane[numOfFishes+1];
		initializeAquarium();
	}

	

	private void initializeAquarium(){
		// erzeuge Fische
		for (int i = 0; i < fishes.length; i++) {
			fishes[i] = new Fish(getRandomPosition(getWidth()), getRandomDirection());
		}
		// erzeuge Schwimmbahnen
		lanes[0] = new Lane(getWidth(), null);
		for (int i = 1; i < getLanes().length; i++) {
			lanes[i] = new Lane(getWidth(), getFishes()[i-1]);
		}
	}
	
	private int getRandomPosition(int width) {
		return (int)((Math.random()) * (width-4) + 1);
	}
	
	private boolean getRandomDirection() {
		return Math.random() < 0.5;
	}

	
	public void showAquarium() {
		for (int i = this.getNumOfFishes(); i >=0; i--) {
			System.out.println(getLanes()[i].printThisLane());
		}
	}
	
	public void letTheFishesSwim(int steps) throws InterruptedException {
		for (int i = 0; i < steps; i++) {
			this.showAquarium();
			for (int j = 1; j < lanes.length; j++) {
				lanes[j].moveFish();
			}
			Thread.sleep(120);
		}
	}
	


	public int getNumOfFishes() {
		return numOfFishes;
	}

	public void setNumOfFishes(int numOfFishes) {
		this.numOfFishes = numOfFishes;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Fish[] getFishes() {
		return fishes;
	}

	public void setFishes(Fish[] fishes) {
		this.fishes = fishes;
	}
	
	public Lane[] getLanes() {
		return lanes;
	}

	public void setLanes(Lane[] lanes) {
		this.lanes = lanes;
	}
	
	
	
	
	
}
