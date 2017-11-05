package game;

public class LevelLoader {
	public static Level loadFromString(String s) {
		return getDefaultLevel(); //TODO loadFromString
	}
	
	public static Level getDefaultLevel() {
		
		Tile[][] field = new Tile[5][5];
		for (int x=0;x<5;x++) {
			for (int y=0;y<5;y++) {
				field[x][y] = null;
			}
		}
		
		field[1][1] = new Stone(1, 1);
		field[3][1] = new Stone(3, 1);
		field[1][3] = new Stone(1, 3);
		field[3][3] = new Stone(3, 3);
	
		field[0][0] = new StoneMoveable(0, 0, StoneMoveable.BLUE);
		field[2][2] = new StoneMoveable(2, 2, StoneMoveable.BLUE);
		field[2][1] = new StoneMoveable(2, 1, StoneMoveable.RED);
		field[0][3] = new StoneMoveable(0, 3, StoneMoveable.RED);
		
		Level l = new Level(0, 4, 4, 0, field);

		
		l.usedColors = l.getUsedColors();
		
		return l;
	}
	
}
