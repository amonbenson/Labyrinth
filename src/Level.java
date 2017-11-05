import java.util.ArrayList;

public class Level {
	
	public int width, height;
	public Tile[][] field; //Kann null sein
	public Player player; //der eigene Spieler
	public Target target; //das Ziel
	
	public int player_spawn_x, player_spawn_y;
	public int target_x, target_y;
	
	public int moves = 0; //Counter für Züge
	
	public int[] usedColors;
	
	public Level(int width, int height, int player_spawn_x, int player_spawn_y, int target_x, int target_y) {
		this.width = width;
		this.height = height;
		this.player = new Player(player_spawn_x, player_spawn_y);
		this.target = new Target(target_x, target_y);
		
		this.target_x = target_x;
		this.target_y = target_y;
		
		
		field = new Tile[width][height];
		
		for (int x = 0;x<width;x++) {
			for (int y = 0;y<height;y++) {
				field[x][y] = null;
			}
		}
		
		//Target hinzufügen:
		field[target_x][target_y] = new Target(target_x, target_y);
		
		//Menschen hinzufügen:
		field[player_spawn_x][player_spawn_y] = new Player(player_spawn_x, player_spawn_y);
		
		usedColors = getUsedColors();
	}
	
	public int[] getUsedColors() {
		ArrayList<Integer> integers = new ArrayList<Integer>();
		for (int x = 0;x<width;x++) {
			for (int y=0;y<height;y++) {
				if (field[x][y] != null) {
					if (field[x][y] instanceof StoneMoveable) {
						StoneMoveable sm = (StoneMoveable) field[x][y];
						if (!integers.contains(sm.ID)) {
							integers.add(sm.ID);
						}
					}
				}
			}
		}
		
		int[] ret = new int[integers.size()];
	    for (int i=0; i < ret.length; i++)
	    {
	        ret[i] = integers.get(i).intValue();
	    }
	    System.out.println(integers);
	    for (int i=0;i<ret.length;i++) {
	    	System.out.println(ret[i]);
	    }
	    return ret;
	    
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
		moves++;
	}
	
	public void moveLeft(int ID) {
		for (int x = 1;x<width;x++) {
			for (int y = 0;y<height;y++) {
				if (field[x][y] instanceof StoneMoveable) {
					
					StoneMoveable sm = (StoneMoveable) field[x][y];
					
					if (sm.ID == ID) {
						if (field[x-1][y] == null ) {
							field[x-1][y] = field[x][y];
							field[x][y] = null;
						}
					}
				}
			}
		}
		moves++;
	}

	public void moveRight(int ID) {
		for (int y = height-1;y>=0;y--) { 
		for (int x = width-2;x>=0;x--) { //x = 0 kann nicht nach oben bewegt werden
				if (field[x][y] instanceof StoneMoveable) {
					
					StoneMoveable sm = (StoneMoveable) field[x][y];
					
					if (sm.ID == ID) {
						if (field[x+1][y] == null ) {
							field[x+1][y] = field[x][y];
							field[x][y] = null;
						}
					}
				}

			}
		}
		moves++;
	}
	
	public void moveDown(int ID) {
		for (int y=height-2;y>=0;y--) {
			for (int x=width-1;x>=0;x--) {
				if (field[x][y] instanceof StoneMoveable) {
					
					StoneMoveable sm = (StoneMoveable) field[x][y];
					
					if (sm.ID == ID) {
						if (field[x][y+1] == null ) {
							field[x][y+1] = field[x][y];
							field[x][y] = null;
						}
					}
				}
			}
		}
		moves++;
	}
	
}
