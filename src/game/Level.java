package game;
import java.util.ArrayList;
import java.util.Arrays;

public class Level {
	
	public int width, height;
	public Tile[][] field; //Kann null sein
	public Player player; //der eigene Spieler
	public Target target; //das Ziel
	
	public int player_spawn_x, player_spawn_y;
	public int target_x, target_y;
	
	public int moves = 0; //Counter für Züge
	
	public int[] usedColors;
	
	public int initial_player_spawn_x, initial_player_spawn_y;
	public Tile[][] initialField;
	
	public Level(int player_spawn_x, int player_spawn_y, int target_x, int target_y, Tile[][] field) {
		this.field = field;
		this.initialField = deepCopy(field);
		this.initial_player_spawn_x = player_spawn_x;
		this.initial_player_spawn_y = player_spawn_y;
		this.width = field.length;
		this.height = field[0].length;
		this.player = new Player(player_spawn_x, player_spawn_y);
		this.target = new Target(target_x, target_y);
		
		this.target_x = target_x;
		this.target_y = target_y;
		
		
		//Menschen hinzufügen:
		field[player_spawn_x][player_spawn_y] = player;
		
		//Target hinzufügen:
		field[target_x][target_y] = target;
		
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

	public void movePlayerUp() {
		if (player.y != 0) {
			if (field[player.x][player.y-1] == null || field[player.x][player.y-1] instanceof Target) {
				field[player.x][player.y-1] = player;
				field[player.x][player.y] = null;
				player.y = player.y -1;
			}
		}
		checkIfTargetReached();
		moves++;
	}

	public void movePlayerDown() {
		if (player.y != height-1) {
			if (field[player.x][player.y+1] == null || field[player.x][player.y+1] instanceof Target) {
				field[player.x][player.y+1] = player;
				field[player.x][player.y] = null;
				player.y = player.y +1;
			}
		}
		checkIfTargetReached();
		moves++;
	}

	public void movePlayerLeft() {
		if (player.x != 0) {
			if (field[player.x-1][player.y] == null || field[player.x-1][player.y] instanceof Target) {
				field[player.x-1][player.y] = player;
				field[player.x][player.y] = null;
				player.x = player.x -1;
			}
		}
		checkIfTargetReached();
		moves++;
	}

	public void movePlayerRight() {
		if (player.x != width-1) {
			if (field[player.x+1][player.y] == null || field[player.x+1][player.y] instanceof Target) {
				field[player.x+1][player.y] = player;
				field[player.x][player.y] = null;
				player.x = player.x +1;
			}
		}
		checkIfTargetReached();
		moves++;
	}
	
	public void checkIfTargetReached() {
		if (player.x == target_x && player.y == target_y) {
			Game.isDone = true;
		}
	}
	
	public void reset() {
		this.field = this.initialField;
		this.moves = 0;
		this.player = new Player(initial_player_spawn_x, initial_player_spawn_y);
		field[initial_player_spawn_x][initial_player_spawn_y] = player;
		field[target_x][target_y] = target;
	}
	
	
	public static Tile[][] deepCopy(Tile[][] original) {
		Tile[][] result = new Tile[original.length][original[0].length];
		for ( int x = 0;x<original.length;x++) {
			for ( int y = 0;y<original[0].length;y++) {
				if (original[x][y] != null) {
					if (original[x][y] instanceof Stone) {
						result[x][y] = new Stone(x, y);
					} else if (original[x][y] instanceof StoneMoveable) {
						result[x][y] = new StoneMoveable((StoneMoveable)original[x][y]);
					} else if (original[x][y] instanceof Player) {
						result[x][y] = new Player(x, y);
					}
				} else {
					result[x][y] = null;
				}
			}
		}
		return result;
	}
}
