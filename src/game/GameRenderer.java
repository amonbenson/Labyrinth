package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class GameRenderer {

	public static final Color[] STONE_MOVABLE_COLORS = new Color[] { Color.blue, Color.green, Color.yellow, Color.red };

	private long animationTime;

	private Color background;
	private int selectedColor;

	public GameRenderer() {
		animationTime = 0;
		
		background = new Color(73, 209, 145);
		selectedColor = -1;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Game game, Graphics g) {
		// Update the animation time
		animationTime = System.currentTimeMillis();
		
		// Update selected color from game
		selectedColor = game.colorSelectID;

		// Set the background
		g.setColor(background);
		g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);

		// Render the tiles
		renderTiles(gc, sbg, game, g);

		// Draw used Moves
		Database.FNT_DEFAULT.drawString(70, 50, "Zuege " + game.level.moves, Color.white);
		
		// Draw the color selector
		drawColorSelector(game, g, 10, 130);
	}
	
	private void drawColorSelector(Game game, Graphics g, float x, float y) {
		// Draw the small tiles
		float tileSize = 128;
		float tileSpace = 8;
		for (int i = 0; i < game.maxIndex; i++) {
			
			float px = x + tileSize / 2;
			float py = y + i * (tileSize + tileSpace);
			
			if (i == 0) {
				Database.IMG_PLAYER.draw(px, py, tileSize, tileSize);
			} else {
				Color color = STONE_MOVABLE_COLORS[game.level.usedColors[i - 1]];
				if (i == game.currentIndexSelecting)
					Database.IMG_STONE_MOVABLE_CHOSEN.draw(px, py, tileSize, tileSize, color);
				else
					Database.IMG_STONE_MOVABLE.draw(px, py, tileSize, tileSize, color);
			}
		}
		
		Database.IMG_SELECTOR.draw(x, y + game.currentIndexSelecting * (tileSize + tileSpace), tileSize * 2, tileSize);
	}

	private void renderTiles(GameContainer gc, StateBasedGame sbg, Game game, Graphics g) {

		// Set the tile transform in the game. This will be used by the input
		// handler to inverse transform the
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
				// Draw the default background tile image
				Database.IMG_TILE.draw(x, y, 1, 1);

				Tile tile = level.field[x][y];

				if (tile != null) {
					// Draw a solid stone texture
					if (tile instanceof Stone) {
						Database.IMG_STONE.draw(x, y, 1, 1);
					}

					if (tile instanceof StoneMoveable) {
						StoneMoveable stone = (StoneMoveable) tile;

						// Render a movable stone
						Color color = STONE_MOVABLE_COLORS[stone.ID];
						if (stone.ID == selectedColor) Database.IMG_STONE_MOVABLE_CHOSEN.draw(x, y, 1, 1, color);
						else Database.IMG_STONE_MOVABLE.draw(x, y, 1, 1, color);
					}
					if (tile instanceof Player) {

						// Make the player wiggle a bit cause why not
						g.pushTransform();
						
						float wiggle = (float) Math.sin(animationTime * 0.01);
						g.rotate(x + 0.5f - wiggle * 1.5f, y + 0.5f, wiggle * 1.3f);
						
						Database.IMG_PLAYER.draw(x, y, 1, 1);
						
						g.popTransform();
					}
				}
			}
		}

		Database.IMG_FINISH.draw(level.target_x, level.target_y, 1, 1);
	}
}
