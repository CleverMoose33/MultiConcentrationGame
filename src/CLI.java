import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {
	public int GridSize;
	public  ArrayList<ArrayList<Tile>> gameGrid;
	public Logic logicClass;
	public CLILogic cliLogic;
	public Scanner s;
	public boolean gameFinished = false;
	
	public CLI(int gridSize){
		//Boolean to quit the game
		boolean _quit = false;
		//Initalize the scanner
		s = new Scanner(System.in);
		//Set global variable for gridSize
		this.GridSize = gridSize;
		//Create an instance of the logic class
		 logicClass = new Logic();
		 
		 //Create the game board
		gameGrid = logicClass.generateGrid(gridSize);
		//Create CLI Logic class
		 cliLogic = new CLILogic(gameGrid, gridSize);
		 
		do{
			//Welcome and rules are displayed
			System.out.println(cliLogic.welcomeMessage());
			
			System.out.println("To begin playing enter 'y', 'q' to quit or anything else to see the directions again.");
			//startGame
			String input = s.nextLine();
			if(input.equalsIgnoreCase("y")){
				playGame();
			}
			else if(input.equalsIgnoreCase("q")){
				_quit = true;
			}
			
		}while(!_quit);
		
		System.exit(0);
	}
	
	public void playGame(){
		//Displays the letters of the grid
		cliLogic.displayLetterGrid();
		//Waits for 5 seconds
		cliLogic.delayGame();
		//Clears the console
		cliLogic.clearScreen();
		//GamePlay loop
		do{
			//local Vars for grid elements to evaluate
			int choice1 = -1; 
			int choice2 = -1;
			boolean goodInput = true;
			String input;
			//Displays the game board
			cliLogic.displayGameGrid();
			s.reset();
			//Take in user input
			try{
				
				//Propt user for first tile
				System.out.println("Please enter the number of the two tiles you would like to flip seperated by a space, R to restart, or Q to quit.");
				
				input = s.nextLine();
				if(input.equalsIgnoreCase("R")){
					newGame();
					System.exit(0);
				}
				if(input.equalsIgnoreCase("Q")){
					System.out.println("Goodbye.");
					System.exit(0);
				}
					
				String[] strgAry = input.split(" ");
					if(strgAry.length< 2){
						System.out.println("Please enter two valid integers");
						continue;
					}
					else if(strgAry.length == 2){
						//Get first int
						choice1 = Integer.parseInt(strgAry[0]);
						//Get second int
						choice2 = Integer.parseInt(strgAry[1]);
					}
					else{
						System.out.println("Please enter two valid integers");
						continue;
					}
				if(choice1 == choice2){
					System.out.println("Please enter two different integers");
					//Repeat loop if values are bad
					goodInput = false;
				}
				//See if values exist in the current set of IDs
				if(!cliLogic.validSelection(choice1, choice2)){
					System.out.println("Please enter a value between 1 and " + GridSize*GridSize);
					//repeat loop if values are bad
					goodInput = false;
				}
			}
			catch(InputMismatchException e){
				//incorrect input
				System.out.println("Please enter a valid integer.");
				goodInput = false;
			}
			//If input is good and we have valid  numbers entered proceed to evaluate the numbers
			if(goodInput && (choice1 != -1 && choice2 != -1)){
				//Check for match
				if(!logicClass.evaluateMatch(cliLogic.getTile(choice1), cliLogic.getTile(choice2))){
					//If they don't match
					System.out.println("Sorry, it looks like those two don't match!");
					//Show game board with the wrong guesses as letters
					cliLogic.dsplyWrongGuessLtrs(choice1, choice2);
					//time delay
					cliLogic.delayGame();
					//clear the screen
					cliLogic.clearScreen();
				}
				//Update the value of game finished
				gameFinished = logicClass.gameFinished(gameGrid);
			}		
			//If game is not finished repeat loop
		}while(!gameFinished);
		cliLogic.displayGameGrid();
		System.out.println("Congratulations! You Win!");
			System.out.println("If  you'd like to play again enter 'y' press anything else to quit");
			if(s.nextLine().equalsIgnoreCase("y")){
				newGame();
			}
			else{
				System.out.println("Thanks for playing!");
			}
		System.exit(0);
	}
	
	/*
	 *Creates a new instance on the CLI class to restart the game. 
	 */
	public void newGame(){
		CLI newGame = new CLI(GridSize);
	}
	
	
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

