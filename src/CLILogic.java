import java.util.ArrayList;

/*
 * Logic class that serves only the CLI interface.
 */
public class CLILogic {
	private ArrayList<ArrayList<Tile>> gameGrid;
	private int gridSize;
	public CLILogic(){}
	public CLILogic(ArrayList<ArrayList<Tile>> gameGrid, int gridSize){
		this.gameGrid = gameGrid;
		this.gridSize = gridSize;
	}
	/*
	 * Valid selection inspects the two integers passed to it
	 * returns true if the two integers are within the bounds of the grid and false if they are not.
	 */
	public boolean validSelection(int choice1, int choice2) {
		return (choice1>= 1 && choice1 <= gridSize*gridSize) && (choice2 >= 1 && choice2 <= gridSize*gridSize);
	}
	/*
	 * Searches for a tile object based on its integer ID in relation to the int passed in.
	 * returns the tile object if one that matches is found.
	 */
	public Tile getTile(int tileID){
		Tile tempTile = null;
		for(ArrayList<Tile> ary: gameGrid){
			for(Tile t : ary){
				if(t.getID() == tileID){
					tempTile = t;
					break;
				}
			}
		}
		return tempTile;
	}
	/*
	 * Prints the game grid based on the current state of the "MatchFound" boolean
	 * if a match has been found the method prints the letter, if no match has been
	 * found the ID number will be printed.
	 */
	public void displayGameGrid(){

			for(ArrayList<Tile> ary: gameGrid){
			for(Tile t : ary){
				if(t.matchFound){
					System.out.print(t.Letter+ "  ");
				}
				else{
					System.out.print(t.getID() + "  ");
				}
			}
				System.out.println("");
			}
		
	}
	/*
	 * Displays all of the letters for the tiles in the game grid on the console.
	 */
	public void displayLetterGrid(){
		if(gameGrid != null){
			for(ArrayList<Tile> ary: gameGrid){
			for(Tile t : ary)
				System.out.print(t.Letter + "  ");
			
			System.out.println("");
			}
		}
	}
	/*
	 * prints 25 new lines to clear the command line.
	 */
	public void clearScreen(){
		for(int i=0; i< 25; i++)
			System.out.println("");
	}
	/*
	 * Halts the program from executing for 10 seconds per the game instructions
	 */
	public void delayGame(){
		//Waits for 10 seconds
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	/*
	 * If the user does not correctly select two tiles this function will display the incorrectly
	 * guessed tile's letter value.
	 * Should be used in conjunction with delayGame() so the answer is not continually displayed
	 */
	public void dsplyWrongGuessLtrs(int choice1, int choice2){
		for(ArrayList<Tile> ary: gameGrid){
			for(Tile t : ary){
				if(t.ID == choice1 || t.ID == choice2){
					System.out.print(t.Letter + "  ");
				}
				else{
					System.out.print(t.ID + "  ");
				}
			}
				System.out.println("");
			}
		
	}

	/*
	 * The Welcome Message is stored in this central location so all of the interfaces can get to it easily.
	 */
		public String welcomeMessage(){
			return "Welcome to the Concentration game! \n" + "The rules are as follows: \n"
					+ "The screen will display a grid of Letters for a short period of time \n"
					+ "and then the screen will clear and the letters of the grid will be replaced with numbers. \n"
					+ "You must remember where the matching numbers are and enter the corresponding numbers, one pair at a time. \n"
					+ "Enter the two numbers on the grid you would like to flip separated by a space I.E.: 2 4 \n"
					+ "If the two places on the grid match the spots will display the letters you found. \n"
					+ "If the two places on the grid you selected do not match the letters will be shown briefly and then the \n"
					+ "grid will be redrawn.\n";
		
		}
}
