import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class GameRenderer {

	public static final Color[] STONE_MOVABLE_COLORS = new Color[] { Color.blue, Color.green, Color.yellow, Color.red };
	
	public GameRenderer() {
	}

	public void render(GameContainer gc, StateBasedGame sbg, Game game, Graphics g) {
		renderTiles(gc, sbg, game, g);
	}

	private void renderTiles(GameContainer gc, StateBasedGame sbg, Game game, Graphics g) {

		// Set the tile transform in the game. This will be used by the input handler to inverse transform the
		// mouse position to a tile position.
		TileTransform tTrans = game.tileTransform;
		
		float fitW = Main.WIDTH / game.level.width;
		float fitH = Main.HEIGHT / game.level.height;
		if (fitW > fitH) {
			tTrans.sx = tTrans.sy = fitH;
			tTrans.x = (Main.WIDTH - tTrans.sx * game.level.width) / 2;
			tTrans.y = 0;
		} else {
			tTrans.sx = tTrans.sy = fitW;
			tTrans.x = 0;
			tTrans.y = (Main.HEIGHT - tTrans.sy * game.level.height) / 2;
		}
		
		// Apply the tile transform
		g.pushTransform();
		tTrans.applyToGraphics(g);
		
		// Render the tiles
		renderTilesFromLevel(g, game.level);
		
		// Remove the transform
		g.popTransform();
	}
	
	public void renderTilesFromLevel(Graphics g, Level level) {
		for (int x = 0; x < level.width; x++) {
			for (int y = 0; y < level.height; y++) {
				Tile tile = level.field[x][y];

				if (tile == null) {
					// Render an empty tile
					g.setColor(Color.white);

				} else {
					if (tile instanceof Stone) {
						// Render a solid stone
						g.setColor(Color.gray);
					}

					if (tile instanceof StoneMoveable) {
						// Render a movable stone
						g.setColor(STONE_MOVABLE_COLORS[((StoneMoveable) tile).ID]);
					}
				}
				
				g.fillRect(x, y, 1, 1);
			}
		}
	}

}
