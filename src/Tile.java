
public class Tile {
	//variable for 
	public int ID;
	public int getID() {
		return ID;
	}
	public char Letter;
	public char getLetter() {
		return Letter;
	}
	public boolean matchFound;
	public boolean getMatchFound(){
		return matchFound;
	}
	public void setMatchFound(boolean bool){
		matchFound = bool;
	}
	
	public Tile(int ID, char Letter){
		this.ID = ID;
		this.Letter = Letter;
	}
}
