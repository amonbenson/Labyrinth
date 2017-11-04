
public class StoneMoveable extends Tile {
	public int ID;
	
	public StoneMoveable(int x, int y, int ID) {
		super(x, y);
		this.ID = ID;
	}
	
	
	public static final int BLUE = 0;
	public static final int GREEN = 1;
	public static final int YELLOW = 2;
	public static final int RED = 3;
}
