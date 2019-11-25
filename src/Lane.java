
public class Lane {

	private int length;
	private Fish myFish;
	private char[] fields;
	
	public Lane(int length, Fish myFish) {
		this.length = length;
		this.myFish = myFish;
		this.fields = new char[this.getLength()];
		initializeLane();
	}
	

	
	// OK
	private void initializeLane() {
		if (getMyFish()==null){ //Sonderfall Aquariumboden
			//lane="+----------------------------------------+".toCharArray();
			fields[0]='+';
			for (int i = 1; i < (this.getLength()-1); i++) {
				this.fields[i]='-';
			}
			fields[getLength()-1]='+';
		} else {
			int fishPosition = myFish.getPosition();
			
			fields[0]='|';
			
			for (int i = 1; i < fishPosition; i++) {
				fields[i]=' ';
			}
			
			if (myFish.getDirection()) { //true = Richtung nach rechts
				fields[fishPosition]='>'; //Position des Fisches
				fields[fishPosition+1]='<';
				fields[fishPosition+2]='>';
			} else {
				fields[fishPosition]='<'; //Position des Fisches
				fields[fishPosition+1]='>';
				fields[fishPosition+2]='<';
			}
			
			for (int i = fishPosition+3; i < this.getLength()-1; i++) { //Position des Fisches
				fields[i]=' ';
			}
			
			fields[this.getLength()-1] = '|';
		}
	}
	
	public void moveFish() {
		int fishPosition = myFish.getPosition();
		
		if (myFish.getDirection()) { //true = Richtung nach rechts
			if(fishPosition==(this.getLength()-4)){ //Fisch stösst rechts an und muss umdrehen
				fields[fishPosition]='<'; //Position des Fisches
				fields[fishPosition+1]='>';
				fields[fishPosition+2]='<';
				myFish.setDirection(false);
			} else {
				fields[fishPosition]=' '; //Position des Fisches
				fields[fishPosition+1]='>'; //Position des Fisches
				fields[fishPosition+2]='<';
				fields[fishPosition+3]='>';
				myFish.setPosition(fishPosition+1);
			}
		} else {					//false = Richtung nach links
			if(fishPosition==1) {	//Fisch stösst links an und muss umdrehen
				fields[fishPosition]='>'; //Position des Fisches
				fields[fishPosition+1]='<';
				fields[fishPosition+2]='>';
				myFish.setDirection(true);
			} else {
				fields[fishPosition-1]='<'; //Position des Fisches
				fields[fishPosition]='>';
				fields[fishPosition+1]='<';	
				fields[fishPosition+2]=' ';
				myFish.setPosition(fishPosition-1);
			}

		}
	}
	
	public String printThisLane() {
		return String.valueOf(fields);
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Fish getMyFish() {
		return myFish;
	}

	public void setMyFish(Fish myFish) {
		this.myFish = myFish;
	}

	public char[] getLane() {
		return fields;
	}

	public void setLane(char[] lane) {
		this.fields = lane;
	}
	
	

}
