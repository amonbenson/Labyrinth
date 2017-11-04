import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class GameRenderer {

	public static final Color[] STONE_MOVABLE_COLORS = new Color[] { Color.blue, Color.green, Color.yellow, Color.red };
	
	private Color background;
	
	
	
	public GameRenderer() {
		background = new Color(73, 209, 145);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Game game, Graphics g) {
		g.setColor(background);
		g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
		renderTiles(gc, sbg, game, g);
		g.drawString("Züge: "+game.level.moves, 50, 50);
		
		
	}

	private void renderTiles(GameContainer gc, StateBasedGame sbg, Game game, Graphics g) {

		// Set the tile transform in the game. This will be used by the input handler to inverse transform the
		// mouse position to a tile position.
		float fitW = Main.WIDTH / game.level.width;
		float fitH = Main.HEIGHT / game.level.height;
		float tileSize, tileX, tileY;
		if (fitW > fitH) {
			tileSize = fitH;
			tileX = (Main.WIDTH - tileSize * game.level.width) / 2;
			tileY = 0;
		} else {
			tileSize = fitW;
			tileX = 0;
			tileY = (Main.HEIGHT - tileSize * game.level.height) / 2;
		}
		
		// Apply the tile transform
		g.pushTransform();
		g.translate(tileX, tileY);
		g.scale(tileSize, tileSize);
		
		// Render the tiles
		renderTilesFromLevel(g, game.level);
		
		
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
					if (tile instanceof Target) {
						g.setColor(Color.darkGray);
					}
				}
				
				g.fillRect(x, y, 1, 1);
			}
		}
	}

}
