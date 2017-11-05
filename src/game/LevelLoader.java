package game;

public class LevelLoader {
	public static Level loadFromString(String s) {
		return getDefaultLevel(); //TODO loadFromString
	}
	
	public static Level[] getLevels() {
		Level[] a = new Level[2];
		a[0] = getDefaultLevel();
		a[1] = getDefaultLevel();
		return a;
	}
	
	public static Level getDefaultLevel() {
		return getLevelOne();
	}
	

	public static Level getLevelFive(){
		return getLevelOne();
	}

	public static Level getLevelFour(){
		Tile[][] field = new Tile[7][7];
		for (int x=0;x<7;x++) {
			for (int y=0;y<7;y++) {
				field[x][y] = null;
			}
		}
		
		field[1][0] = new Stone(1, 0);
		field[1][1] = new Stone(1, 1);
		field[1][2] = new Stone(1, 2);
		field[1][4] = new Stone(1, 4);
		field[1][5] = new Stone(1, 5);
		field[1][6] = new Stone(1, 6);
		
		field[3][0] = new Stone(3, 0);
		field[3][1] = new Stone(3, 1);
		field[3][2] = new Stone(3, 2);
		field[3][4] = new Stone(3, 4);
		field[3][5] = new Stone(3, 5);
		field[3][6] = new Stone(3, 6);

		field[5][0] = new Stone(5, 0);
		field[5][1] = new Stone(5, 1);
		field[5][2] = new Stone(5, 2);
		field[5][4] = new Stone(5, 4);
		field[5][5] = new Stone(5, 5);
		field[5][6] = new Stone(5, 6);

		field[6][6] = new Stone(6, 6);
		
		field[0][3] = new StoneMoveable(0, 3, StoneMoveable.BLUE);
		field[0][2] = new StoneMoveable(0, 2, StoneMoveable.RED);
		field[0][1] = new StoneMoveable(0, 1, StoneMoveable.GREEN);

		field[2][0] = new StoneMoveable(2, 0, StoneMoveable.BLUE);
		field[2][1] = new StoneMoveable(2, 1, StoneMoveable.BLUE);
		field[2][2] = new StoneMoveable(2, 2, StoneMoveable.BLUE);
		field[2][4] = new StoneMoveable(2, 4, StoneMoveable.BLUE);
		field[2][5] = new StoneMoveable(2, 5, StoneMoveable.BLUE);
		field[2][6] = new StoneMoveable(2, 6, StoneMoveable.BLUE);

		field[4][0] = new StoneMoveable(4, 0, StoneMoveable.RED);
		field[4][1] = new StoneMoveable(4, 1, StoneMoveable.RED);
		field[4][2] = new StoneMoveable(4, 2, StoneMoveable.RED);
		field[4][3] = new StoneMoveable(4, 3, StoneMoveable.RED);
		field[4][4] = new StoneMoveable(4, 4, StoneMoveable.RED);
		field[4][5] = new StoneMoveable(4, 5, StoneMoveable.RED);
		field[4][6] = new StoneMoveable(4, 6, StoneMoveable.RED);

		field[5][3] = new StoneMoveable(5, 3, StoneMoveable.RED);
		
		Level l = new Level(0, 6, 6, 0, field);
		l.usedColors = l.getUsedColors();
		
		return l;
	}
	
	public static Level getLevelThree(){
		Tile[][] field = new Tile[6][6];
		for (int x=0;x<6;x++) {
			for (int y=0;y<6;y++) {
				field[x][y] = null;
			}
		}
		
		field[1][1] = new Stone(1, 1);
		field[3][1] = new Stone(3, 1);
		field[1][3] = new Stone(1, 3);
		field[1][5] = new Stone(1, 5);

		field[3][0] = new Stone(3, 0);
		field[3][1] = new Stone(3, 1);
		field[3][2] = new Stone(3, 2);
		field[3][3] = new Stone(3, 3);
		field[4][3] = new Stone(4, 3);
		
		field[3][5] = new Stone(3, 5);
		field[4][5] = new Stone(4, 5);
		
		field[0][4] = new StoneMoveable(0, 4, StoneMoveable.BLUE);
		field[1][2] = new StoneMoveable(1, 2, StoneMoveable.BLUE);
		field[0][2] = new StoneMoveable(0, 2, StoneMoveable.BLUE);
		field[4][4] = new StoneMoveable(4, 4, StoneMoveable.BLUE);
		field[2][3] = new StoneMoveable(2, 3, StoneMoveable.BLUE);
		field[5][2] = new StoneMoveable(5, 2, StoneMoveable.BLUE);
		
		field[3][4] = new StoneMoveable(3,4, StoneMoveable.RED);
		field[0][3] = new StoneMoveable(0, 3, StoneMoveable.RED);
		field[1][4] = new StoneMoveable(1, 4, StoneMoveable.RED);
		field[2][1] = new StoneMoveable(2, 1, StoneMoveable.RED);
		field[0][0] = new StoneMoveable(0, 0, StoneMoveable.RED);
		field[0][1] = new StoneMoveable(0, 1, StoneMoveable.RED);

		field[5][1] = new StoneMoveable(5, 1, StoneMoveable.YELLOW);
		
		field[4][2] = new StoneMoveable(4, 2, StoneMoveable.GREEN);
		
		Level l = new Level(0, 5, 5, 0, field);
		l.usedColors = l.getUsedColors();
		
		return l;
	}
	
	public static Level getLevelTwo(){
		Tile[][] field = new Tile[7][7];
		for (int x=0;x<7;x++) {
			for (int y=0;y<7;y++) {
				field[x][y] = null;
			}
		}
		
		field[1][2] = new Stone(1, 2);
		field[1][3] = new Stone(1, 3);
		field[1][4] = new Stone(1, 4);
		field[3][0] = new Stone(3, 0);
		field[3][1] = new Stone(3, 1);		
		field[3][2] = new Stone(3, 2);
		field[3][4] = new Stone(3, 4);
		field[3][5] = new Stone(3, 5);
		field[3][6] = new Stone(3, 6);
		field[5][2] = new Stone(5, 2);
		field[5][3] = new Stone(5, 3);
		field[5][4] = new Stone(5, 4);
		
		field[0][2] = new StoneMoveable(0, 2, StoneMoveable.BLUE);
		field[0][3] = new StoneMoveable(0, 3, StoneMoveable.YELLOW);
		field[1][1] = new StoneMoveable(1, 1, StoneMoveable.RED);
		field[1][5] = new StoneMoveable(1, 5, StoneMoveable.RED);
		field[2][2] = new StoneMoveable(2, 2, StoneMoveable.BLUE);
		field[2][4] = new StoneMoveable(2, 4, StoneMoveable.YELLOW);
		field[3][3] = new StoneMoveable(3, 3, StoneMoveable.RED);
		field[4][2] = new StoneMoveable(4, 2, StoneMoveable.BLUE);
		field[4][4] = new StoneMoveable(4, 4, StoneMoveable.YELLOW);
		field[5][1] = new StoneMoveable(5, 1, StoneMoveable.RED);
		field[5][5] = new StoneMoveable(5, 5, StoneMoveable.RED);
		field[6][2] = new StoneMoveable(6, 2, StoneMoveable.BLUE);
		field[6][3] = new StoneMoveable(6, 3, StoneMoveable.YELLOW);
		
		Level l = new Level(0, 6, 6, 0, field);
		l.usedColors = l.getUsedColors();
		return l;
	}

	public static Level getLevelOne(){
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
	
	public static Level getTutorialLevel() {
		Tile[][] field = new Tile[4][4];
		for (int x=0;x<4;x++) {
			for (int y=0;y<4;y++) {
				field[x][y] = null;
			}
		}
		
		field[2][0] = new Stone(2, 0);
		field[2][1] = new Stone(2, 1);
		field[2][3] = new Stone(2, 3);
		
		

		field[2][2] = new StoneMoveable(2, 2, StoneMoveable.BLUE);
		field[2][3] = new StoneMoveable(2, 3, StoneMoveable.RED);

		
		Level l = new Level(0, 3, 3, 0, field);
		l.usedColors = l.getUsedColors();
		
		return l;
	}
}
