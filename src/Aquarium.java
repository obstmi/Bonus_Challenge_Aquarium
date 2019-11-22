
public class Aquarium {

	int numOfFishes;
	int width;
	Fish[] fishes;
	char[][] pool;

	//Test-Konstruktor mit 4 Fischen im 42er Aquarium:
	public Aquarium() {
		super();
		this.numOfFishes = 4;
		this.width = 42;
		this.fishes = new Fish[4];
		this.pool = new char[this.getNumOfFishes()+1][this.getWidth()];
		fishes[0] = new Fish(5, true); //ToDo: initiale Zufallsposition
		fishes[1] = new Fish(25, false);
		fishes[2] = new Fish(10, false);
		fishes[3] = new Fish(35, true);

		initializeAquarium();
	}
	
	
	public Aquarium(int numOfFishes, int width) {
		super();
		this.numOfFishes = numOfFishes;
		this.width = width;
		this.fishes = new Fish[4];
		this.pool = new char[this.getNumOfFishes()+1][this.getWidth()];
		
	}
	
	public void showAquarium() {
		for (int i = this.getNumOfFishes(); i >=0; i--) {
			System.out.println("Zeile "+i+ " :"+ String.valueOf(pool[i]));
		}
	}
	
	public void letTheFishesSwim(int steps) {
		for (int i = 0; i < steps; i++) {
			this.showAquarium();
			// this.fishMove();
			// wait..
		}
	}
	
	
	private char[] generateLane(Fish myFish){
		char[] line = new char[this.getWidth()];
		int fishPosition = myFish.getPosition();
		
		line[0]='|';
		
		for (int i = 1; i < fishPosition; i++) {
			line[i]=' ';
		}
		
		if (myFish.getDirection()) { //true = Richtung nach rechts
			line[fishPosition]='>'; //Position des Fisches
			line[fishPosition+1]='<';
			line[fishPosition+2]='>';
		} else {
			line[fishPosition]='<'; //Position des Fisches
			line[fishPosition+1]='>';
			line[fishPosition+2]='<';
		}
		
		for (int i = fishPosition+3; i < this.getWidth()-1; i++) { //Position des Fisches
			line[i]=' ';
		}
		
		line[this.getWidth()-1] = '|';
		
		return line;
		
	}
	
	private void initializeAquarium(){
		this.pool[0]="+----------------------------------------+".toCharArray();
		for (int i = 0; i < getFishes().length; i++) {
			this.pool[i+1] = generateLane(getFishes()[i]);
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
	
	
	
	
	
}
