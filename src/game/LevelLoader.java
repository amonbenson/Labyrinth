package game;

public class LevelLoader {
	public static Level loadFromString(String s) {
		return getDefaultLevel(); //TODO loadFromString
	}
	
	public static Level getDefaultLevel() {
		Level l = new Level(5, 5, 0, 4, 4, 0);
		l.field[1][1] = new Stone(1, 1);
		l.field[3][1] = new Stone(3, 1);
		l.field[1][3] = new Stone(1, 3);
		l.field[3][3] = new Stone(3, 3);
	
		l.field[0][0] = new StoneMoveable(0, 0, StoneMoveable.BLUE);
		l.field[2][2] = new StoneMoveable(2, 2, StoneMoveable.BLUE);
		l.field[2][1] = new StoneMoveable(2, 1, StoneMoveable.RED);
		l.field[0][3] = new StoneMoveable(0, 3, StoneMoveable.RED);
		return l;
	}
	
}
