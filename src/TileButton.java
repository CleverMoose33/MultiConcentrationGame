import javax.swing.JButton;

public class TileButton<T> extends JButton 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tile tile;
	
	public Tile getTile()
	{
		return this.tile;
	}
	
	public void setTile (Tile tile)
	{
		this.tile = tile;
	}
	
}