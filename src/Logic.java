import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
 * Class for general logic to be used by the GUI and CLI interfaces.
 */
public class Logic {

	/*
	 * This function creates a grid filled with tiles objects and depends on the
	 * Tile class and the generateCharList method.
	 */
	public ArrayList<ArrayList<Tile>> generateGrid(int gridSize){
		//Create 2D grid arrayList
		ArrayList<ArrayList<Tile>> tiles = new ArrayList<ArrayList<Tile>>();
		//assert that gridSize variable is correct
		assert (gridSize == 2 || gridSize == 4 || gridSize == 6);
		//Create the letter values for the grid.
		String charList = generateCharList(gridSize);
		//declare tile ID counter
		int tileCounter = 1;
		//Loop for rows
		for(int i = 0; i < gridSize; i++){
			//Declare new arraylist to store columns for this particular row
			 ArrayList<Tile> tileList = new ArrayList<Tile>();
			 //loop for columns
			for(int j = 0; j < gridSize; j++){
				//add new tile to column
				tileList.add(new Tile(tileCounter, charList.charAt(tileCounter -1)));
				tileCounter++;
			}
			//Check to make sure this row has enough columns
			assert tileList.size() == gridSize;
			tiles.add(tileList);
		}
		//Check to make sure we have enough rows
		assert tiles.size() == gridSize;
		//Make sure our final ID is correct
		assert tiles.get(gridSize-1).get(gridSize-1).ID == gridSize * gridSize;
		
		return tiles;
	}
	/*
	 * This function generates a string of random letters based on the size of a grid.
	 */
	public String generateCharList(int gridSize){
		String charList = "";	
		String returnString = "";
		int loopLength = (gridSize*gridSize) / 2;
		for(int i =0; i < loopLength; i++){
				charList +=  Character.toString((char) (i+65));
				charList +=  Character.toString((char) (i+65));
			
		}
		assert charList.length() == gridSize * gridSize;
		List<String> letters = Arrays.asList(charList.split(""));
		Collections.shuffle(letters);
		for(String letter: letters){
			returnString += letter;
		}
		assert returnString.length() == charList.length() && returnString.length() == gridSize * gridSize;
		
		return returnString;
	}
	/*
	 * Evaluate Match determins if the char value in both of these tiles is equivalent.
	 * If the values match the "matchFound" value will be set to true in the tile objects.
	 */
	public boolean evaluateMatch(Tile tile1, Tile tile2){
		boolean match = tile1.getLetter() == tile2.getLetter();
		if(match){
			tile1.matchFound = match;
			tile2.matchFound = match;
		}
		return match;
	}
	/*
	 * Game finished takes in a array list of array lists that contain tile objects
	 * if all of the tile objects "matchfound" value is true then the game is over
	 * and this function will return true. Otherwise this function will return false.
	 */
	public boolean gameFinished(ArrayList<ArrayList<Tile>> gameBoard){
		boolean _gameFinished = true;
		for(ArrayList<Tile> ary: gameBoard){
			for(Tile t : ary){
				if(!t.matchFound)
					_gameFinished = false;
			}
		}
		
		return _gameFinished;
	}


}
