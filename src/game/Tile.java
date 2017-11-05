package game;

public class Tile implements Cloneable {
	public int x, y;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Tile(Tile t) {
		this.x = t.x;
		this.y = t.y;
	}
	
	@Override
	public Tile clone() {
		return new Tile(x, y);
	}
}
