
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
	
	//Bewegt eine bestimmte MoveableStone Gruppe nach oben
	public void moveUp(int ID) {
		
		for (int x = 0;x<width;x++) { 
			for (int y = 1;y<height;y++) { //y = 0 kann nicht nach oben bewegt werden
				if (field[x][y] instanceof StoneMoveable) {
					
					StoneMoveable sm = (StoneMoveable) field[x][y];
					
					if (sm.ID == ID) {
						if (field[x][y-1] == null ) {
							field[x][y-1] = field[x][y];
							field[x][y] = null;
						}
					}
				}

			}
		}
		
	}
	
	public void moveLeft(int ID) {
		
	}
	
}
