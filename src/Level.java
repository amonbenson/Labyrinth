
public class Level {
	
	public int width, height;
	public Tile[][] field; //Kann null sein
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		field = new Tile[width][height];
		
		for (int x = 0;x<width;x++) {
			for (int y = 0;y<height;y++) {
				field[x][y] = null;
			}
		}
		
	}
	
	
	
}
