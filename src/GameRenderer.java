import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class GameRenderer {
	
	public static final int TILE_SIZE;
	
	public void render(GameContainer gc, StateBasedGame sbg, Game game, Graphics g) {
		renderTiles(gc, sbg, game, g);
	}

	
	
	private void renderTiles(GameContainer gc, StateBasedGame sbg, Game game, Graphics g) {
		for (int x = 0;x<game.level.width;x++) {
			for (int y = 0;y<game.level.height;y++) {
				if (game.level.field[x][y] != null) { //Game Tiles können auch null sein
					Tile t = game.level.field[x][y];
					if (t instanceof Stone) {
						
					}
				}
			}
		}
	}
	
}
