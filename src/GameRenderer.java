import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class GameRenderer {

	public static final Color[] STONE_MOVABLE_COLORS = new Color[] { Color.blue, Color.green, Color.yellow, Color.red };

	float tileSize;

	public GameRenderer() {
		tileSize = 0;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Game game, Graphics g) {
		renderTiles(gc, sbg, game, g);
	}

	private void renderTiles(GameContainer gc, StateBasedGame sbg, Game game, Graphics g) {

		tileSize = Math.min(Main.WIDTH / game.level.width, Main.HEIGHT / game.level.height);

		for (int x = 0; x < game.level.width; x++) {
			for (int y = 0; y < game.level.height; y++) {
				Tile tile = game.level.field[x][y];

				float dx = x * tileSize;
				float dy = y * tileSize;
				float ds = tileSize;

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
				
				g.fillRect(dx, dy, ds, ds);
				
				g.setColor(Color.black);
				g.drawRect(dx, dy, ds, ds);
			}
		}
	}

}
