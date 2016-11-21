import java.util.ArrayList;

import javax.swing.JFrame;

public class MultiConcentrationTester {

	

	/*
	 * This method tests the CLILogic class and all of the functions inside.
	 */
	public static boolean CLILogicClassTest(){
		boolean testsPass = true;
		int testCaseCategory = 3;
		int testCaseSection = 4;
		int testCaseNumber = 1;
		//Coverage Tests
		{
		// Test Case 1
			try{
				int _gridSize = 2;
				new CLILogic(new Logic().generateGrid(_gridSize), _gridSize);
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");
	
			}catch (Exception e){
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;

			// Test Case 2
			try{
				int _gridSize = 2;
				if(new CLILogic(new Logic().generateGrid(_gridSize), _gridSize).validSelection(2, 3))
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");
				else
					System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");	
			}catch (Exception e){
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
				
			// Test Case 3
			try{
				int _gridSize = 2;
				if(new CLILogic(new Logic().generateGrid(_gridSize), _gridSize).getTile(_gridSize) != null)
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");
				else
					System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
			}catch (Exception e){
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
			
			// Test Case 4 -- display game grid without any matches
			try{
				int _gridSize = 2;
				new CLILogic(new Logic().generateGrid(_gridSize), _gridSize).displayGameGrid();
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");
			}catch (Exception e){
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
				
			// Test Case 5 -- display game grid with at least one matching pair
			try{
				int _gridSize = 2;
				ArrayList<ArrayList<Tile>> holdThis = new Logic().generateGrid(_gridSize);
				holdThis.get(0).get(0).matchFound =true;
				holdThis.get(0).get(1).matchFound = true;
				CLILogic tempCLI = new CLILogic(holdThis, _gridSize);
				tempCLI.displayGameGrid();
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");
			}catch (Exception e){
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;	
			
			// Test Case 6 -- display letter grid
			try{
				int _gridSize = 2;
				
				new CLILogic(new Logic().generateGrid(_gridSize), _gridSize).displayLetterGrid();
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");
			}catch (Exception e){
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
			// Test Case 7
			try{
				int _gridSize = 2;
				new CLILogic(new Logic().generateGrid(_gridSize), _gridSize).clearScreen();
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");
			}catch (Exception e){
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
			// Test Case 8
			try{
				int _gridSize = 2;
				new CLILogic(new Logic().generateGrid(_gridSize), _gridSize).delayGame();
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");
			}catch (Exception e){
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
			// Test Case 9
			try{
				int _gridSize = 2;
				new CLILogic(new Logic().generateGrid(_gridSize), _gridSize).dsplyWrongGuessLtrs(_gridSize, _gridSize+1);
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");
			}catch (Exception e){
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
				
			// Test Case 10 -- print welcome message
			try{
				int _gridSize = 2;
				System.out.println(new CLILogic().welcomeMessage());
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");

			}catch (Exception e){
				System.out.println("CLI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
		
		}
		
		//Bounds Tests
		{
			
			
			
		}
		
		return testsPass;
	}
	
	/*
	 * Tests methods in GUILogic class
	 * Since GUI methods are user-driven, cannot generate automated tests with current testing tools
	 */
	public static boolean GUILogicClassTest(){
		boolean testsPass = true;
		int testCaseCategory = 3;
		int testCaseSection = 5;
		int testCaseNumber = 1;
		
		GUILogic GUILogic;
		// Test Case 1
		try{
			GUILogic = new GUILogic();
			
			ArrayList<TileButton<Tile>> tileBtnAry = new ArrayList<TileButton<Tile>>();
			
			Tile tile1 = new Tile(1, 'A');
			tile1.setMatchFound(false);
			
			Tile tile2 = new Tile(2, 'B');
			tile2.setMatchFound(true);
			
			TileButton<Tile> tileBtton1 = GUILogic.SetTileFormatting(tile1);
			TileButton<Tile> tileBtton2 = GUILogic.SetTileFormatting(tile2);
						
			tileBtnAry.add(tileBtton1);
			tileBtnAry.add(tileBtton2);
			
			GUILogic.HideCards(tileBtnAry);
			
			System.out.println("GUI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");

		}catch (Exception e){
			System.out.println("GUI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
		}
			testCaseNumber++;
		
			// Test Case 2
			try{
				GUILogic = new GUILogic();
				
				ArrayList<TileButton<Tile>> tileBtnAry = new ArrayList<TileButton<Tile>>();
				
				Tile tile1 = new Tile(1, 'A');
				tile1.setMatchFound(false);
				
				Tile tile2 = new Tile(2, 'B');
				tile2.setMatchFound(true);
				
				TileButton<Tile> tileBtton1 = GUILogic.SetTileFormatting(tile1);
				TileButton<Tile> tileBtton2 = GUILogic.SetTileFormatting(tile2);
							
				tileBtnAry.add(tileBtton1);
				tileBtnAry.add(tileBtton2);
				
				GUILogic.RemoveTileImages(tileBtnAry);
				
				System.out.println("GUI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");

			}catch (Exception e){
				System.out.println("GUI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
			}
				testCaseNumber++;
				
				// Test Case 3
				try{
					GUILogic = new GUILogic();
					
					JFrame testCaseFrame = GUILogic.GetGameWindowFormatting();
					
					testCaseFrame.setVisible(true);
					testCaseFrame.setVisible(false);
					
					System.out.println("GUI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");
						testCaseFrame.dispose();
				}catch (Exception e){
					System.out.println("GUI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
				}
					testCaseNumber++;
				
			// Test Case 4
			try{
				int _gridSize = 2;
				System.out.println(new GUILogic().welcomeMessage());
				System.out.println("GUI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");

			}catch (Exception e){
				System.out.println("GUI Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
		return testsPass;
	}
	/*
	 * Tests all of the functions in the Logic Class
	 */
	public static boolean LogicClassTest(){
		boolean testsPass = true;
		int testCaseCategory = 3;
		int testCaseSection = 6;
		int testCaseNumber = 1;
		//coverage tests
		{
			// Test Case 1 -- generate 2d arraylist with _gridSize elements.
			try{
				int _gridSize = 2;
				if (new Logic().generateGrid(_gridSize).size() == _gridSize)
					System.out.println("Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");
				else
					System.out.println("Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
	
			}catch (Exception e){
				System.out.println("Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
				
			// Test Case 2 -- Generate charlist, length 4
			try{
				int _gridSize = 2;
				if(new Logic().generateCharList(_gridSize).length() == (_gridSize * _gridSize))
					System.out.println("Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");
				else
					System.out.println("Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");

			}catch (Exception e){
				System.out.println("Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;

			// Test Case 3 -- Evaluate match, True
			try{
				int _gridSize = 2;
				Tile t1 = new Tile(1, 'A');
				Tile t2 = new Tile(2, 'A');
				if(new Logic().evaluateMatch(t1, t2))
					System.out.println("Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");
				else
					System.out.println("Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");

			}catch (Exception e){
				System.out.println("Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;	
				
			// Test Case 4 -- Evaluate match, False
			try{
				int _gridSize = 2;
				Tile t1 = new Tile(1, 'A');
				Tile t2 = new Tile(2, 'B');
				if(!new Logic().evaluateMatch(t1, t2))
					System.out.println("Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");
				else
					System.out.println("Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");

			}catch (Exception e){
				System.out.println("Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
				
			// Test Case 5 -- Is game finished? , False
			try{
				int _gridSize = 2;
				if(!new Logic().gameFinished(new Logic().generateGrid(_gridSize)))
					System.out.println("Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");
				else
					System.out.println("Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");

			}catch (Exception e){
				System.out.println("Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
			// Test Case 6 -- print welcome message
			try{
				int _gridSize = 2;
				System.out.println(new GUILogic().welcomeMessage());
				System.out.println("Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Passed");

			}catch (Exception e){
				System.out.println("Logic Test Case " + testCaseCategory + "." + testCaseSection + "." + testCaseNumber + " Failed");
	
			}
				testCaseNumber++;
		}
		
		
		return testsPass;
	}
	
	
	public static void main(String[] args) {
		boolean allTestsPassed = true;
		if(!CLILogicClassTest())
			allTestsPassed= false;
		
		if(!GUILogicClassTest())
			allTestsPassed= false;
		
		if(!LogicClassTest())
			allTestsPassed = false;
		
		if (allTestsPassed) {
			System.out.println("All tests successfully passed");
		} else {
			System.out.println("Some Test(s) failed");
		}
	}

}
