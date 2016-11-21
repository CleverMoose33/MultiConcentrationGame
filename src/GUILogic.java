import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

public class GUILogic {

	public static final int gameBoardHorzSize = 800;
	public static final int gameBoardVertSize = 800;

	/*
	 * / Hide cards by setting card image
	 */
	public void HideCards(ArrayList<TileButton<Tile>> tileBtnAry) {
		for (TileButton<Tile> tileBtn : tileBtnAry) {
			if (!tileBtn.getTile().getMatchFound())
				tileBtn.setIcon(new ImageIcon("cardicon.png"));
			else {
				tileBtn.setBorder(new LineBorder(Color.black, 4));
			}
		}
	}

	/*
	 * /Remove Card Images so Tile letters are viewable
	 */
	public void RemoveTileImages(ArrayList<TileButton<Tile>> tileBtnAry) {
		for (TileButton<?> tileBtn : tileBtnAry) {
			tileBtn.setIcon(null);
		}
	}

	/*
	 * Sets all initial formatting for TileButtons
	 */
	public TileButton<Tile> SetTileFormatting(Tile tile) {
		TileButton<Tile> tileBtn = new TileButton<Tile>();
		tileBtn.setTile(tile);
		tileBtn.setText(String.valueOf(tile.Letter));
		tileBtn.setFont(new Font("Arial", Font.PLAIN, 40));
		// Default tile border color
		tileBtn.setBorder(new LineBorder(Color.black, 4));

		return tileBtn;

	}

	/*
	 * Set all initial formatting for GameWindow
	 */
	public JFrame GetGameWindowFormatting() {
		JFrame gameWindow = new JFrame();
		gameWindow.setTitle("Multi Concentration Game");
		gameWindow.setSize(gameBoardHorzSize, gameBoardVertSize);

		Dimension minimumSize = new Dimension(gameBoardHorzSize, gameBoardVertSize);
		gameWindow.setMinimumSize(minimumSize);

		return gameWindow;
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
					+ "grid will be redrawn.\n" + "click OK when you are ready to start!";
		
		}
}
