import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class GUI {
	// Size of Game Grid, passed via Main class
	public int GridSize;

	// Length of time to show board, static for all board sizes
	public static final int timerDelay = 10000;

	// Global GUI elements
	public JFrame gameWindow;
	public Logic gameLogic;
	public GUILogic GUILogic;
	public JPanel tileBoard;

	// ArrayList elements
	public ArrayList<ArrayList<Tile>> gameTilesAry;
	public ArrayList<Tile> selectedTilesAry = new ArrayList<Tile>();
	public ArrayList<TileButton<Tile>> tileBtnAry;

	public GUI(int gridSize) {
		this.GridSize = gridSize;

		// Instantiating Logic classes to get ArrayList of Tiles
		gameLogic = new Logic();
		GUILogic = new GUILogic();

		// Getting formatting for gameWindow JFrame
		gameWindow = GUILogic.GetGameWindowFormatting();

		// Create Main Menu
		gameWindow.setJMenuBar(CreateGameMenu());

		// Welcome Message
		JOptionPane.showMessageDialog(gameWindow, GUILogic.welcomeMessage());

		StartGame();
	}

	/*
	 * Main Method to set up game
	 */
	public void StartGame() {
		// Create GameBoard
		CreateGameBoard(GridSize);
		ShowTiles();
	}

	/*
	 * / Show tiles to user for 10 seconds, then hide tiles that were not found
	 */
	public void ShowTiles() {
		GUILogic.RemoveTileImages(tileBtnAry);

		// Redraw gameWindow and tiles, need to fix visual issues with Swing
		gameWindow.revalidate();
		gameWindow.repaint();
		tileBoard.revalidate();
		tileBoard.repaint();

		// Event to hide cards, cannot use Thread.sleep in Swing
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				GUILogic.HideCards(tileBtnAry);
				Timer time = (Timer) evt.getSource();
				time.stop();
			}
		};
		new Timer(timerDelay, taskPerformer).start();
	}

	/*
	 * Creates Menu Bar menu at top of GameWindow and handles all Menu Bar
	 * events
	 */
	public JMenuBar CreateGameMenu() {
		JMenuBar menuBar = new JMenuBar();

		/*
		 * New Game choice menu item and onclick event
		 */
		JMenuItem newGameMnuItm = new JMenuItem("Restart Game");
		newGameMnuItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (JOptionPane.showConfirmDialog(gameWindow, "Press Yes to restart game", "Confirmation Dialog",
						JOptionPane.YES_NO_OPTION) == 0) {
					gameWindow.remove(tileBoard);
					StartGame();
				}
			}
		});

		/*
		 * Exit choice menu item and onclick event
		 */
		JMenuItem exitMnuItm = new JMenuItem("Exit Game");
		exitMnuItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (JOptionPane.showConfirmDialog(gameWindow, "Press Yes to exit game", "Confirmation Dialog",
						JOptionPane.YES_NO_OPTION) == 0)
					System.exit(0);
			}
		});

		/*
		 * Confirm choice menu item and onclick event
		 */
		JMenuItem confirmCardsMnuItm = new JMenuItem("Confirm Choices");
		confirmCardsMnuItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Comparing tiles stuff, if correct, reveal buttons, reset all
				// other buttons
				if (selectedTilesAry.size() == 2) {
					// Sending selected tiles to logic class for eval
					if (gameLogic.evaluateMatch(selectedTilesAry.get(0), selectedTilesAry.get(1))) {
						for (Tile slctedTle : selectedTilesAry) {
							for (TileButton<?> tileBtn : tileBtnAry) {
								Tile tile = tileBtn.getTile();

								if (tile.ID == slctedTle.ID && tile.Letter == slctedTle.Letter) {
									tileBtn.setBorder(new LineBorder(Color.black, 4));
									tileBtn.getTile().setMatchFound(true);
									tileBtn.setIcon(null);
								}
							}
						}
						CheckGameState();

						// Clear selected tiles
						selectedTilesAry.clear();
					} else {
						JOptionPane.showMessageDialog(gameWindow,
								"Incorrect, we will show cards " + "again briefly then hide the board");
						ShowTiles();
					}
				}
			}
		});

		menuBar.add(newGameMnuItm);
		menuBar.add(exitMnuItm);
		menuBar.add(confirmCardsMnuItm);

		return menuBar;
	}

	/*
	 * Generates GameBoard. Creates new set of cards
	 */
	public void CreateGameBoard(int gridSize) {
		// Get new list of Tiles
		gameTilesAry = gameLogic.generateGrid(gridSize);

		tileBoard = new JPanel(new GridLayout(gridSize, gridSize));

		// Create new Btn array, used to track items for evaluation methods
		tileBtnAry = new ArrayList<TileButton<Tile>>();

		for (ArrayList<Tile> subAryGameTls : gameTilesAry) {
			for (Tile tile : subAryGameTls) {
				TileButton<Tile> tileBtn = CreateTile(tile);
				tileBtnAry.add(tileBtn);
			}
		}

		// Add buttons from array to JPanel
		for (TileButton<Tile> tileBtn : tileBtnAry)
			tileBoard.add(tileBtn);

		gameWindow.add(tileBoard);
		gameWindow.setVisible(true);
	}

	/*
	 * Creates single tile for gameboard Handles TileButton parameters and
	 * events
	 */
	public TileButton<Tile> CreateTile(Tile tile) {
		TileButton<Tile> tileBtn = GUILogic.SetTileFormatting(tile);

		// Adding on click event for tile
		tileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TileButton<?> clickedBtn = (TileButton<?>) e.getSource();
					Tile tile = clickedBtn.getTile();

					// Verify User is not trying to select tiles when board
					// shown
					if (clickedBtn.getIcon() != null) {
						// Verify tile has not already been "found"
						if (!tile.getMatchFound()) {
							// Updating btn color when clicked
							LineBorder btnBrdr = (LineBorder) clickedBtn.getBorder();
							Color btnBrdrClr = btnBrdr.getLineColor();

							if (btnBrdrClr == Color.black) {
								if (selectedTilesAry.size() < 2) {
									// User selecting new tile, add id to list
									selectedTilesAry.add(tile);
									clickedBtn.setBorder(new LineBorder(Color.yellow, 4));
								}
							} else {
								// User unselecting tile, remove from list
								selectedTilesAry.remove(tile);
								selectedTilesAry.trimToSize();
								clickedBtn.setBorder(new LineBorder(Color.black, 4));
							}
						}
					}
				} catch (Exception exec) {
					exec.printStackTrace();
				}
			}
		});
		return tileBtn;
	}

	/*
	 * Check if game won by examining tiles If won, return congratulations
	 * message and ask to play again
	 */
	public void CheckGameState() {
		if (gameLogic.gameFinished(gameTilesAry)) {
			if (JOptionPane.showConfirmDialog(gameWindow,
					"Congratulations, You Win! \n" + "Press Yes to restart game or No to quit", "Confirmation Dialog",
					JOptionPane.YES_NO_OPTION) != 0) {
				System.exit(0);
			} else {
				gameWindow.remove(tileBoard);
				StartGame();
			}
		}
	}
}