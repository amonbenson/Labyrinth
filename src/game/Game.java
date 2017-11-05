package game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {

	public static final int ID = 1;
	
	private StateBasedGame game;
	private GameRenderer renderer;
	private InputHandler input;
	
	public TileTransform tileTransform;
	
	public Level level = null; //das aktuelle Level mit allen interessanten Daten
	
	/*
	 * [0] heiﬂt Mensch wurde ausgew‰hlt,
	 * [1], [2...] die usedColors
	 */
	public int currentIndexSelecting = 0;
	public int maxIndex;
	public static final int selectPlayer = 0;
	
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.game = sbg;
		
		tileTransform = new TileTransform();
		
		renderer = new GameRenderer();
		input = new InputHandler();
		
		level = LevelLoader.getDefaultLevel();
		maxIndex = level.usedColors.length+1;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		renderer.render(gc, sbg, this, g);
		
		Point p = tileTransform.getTilePosition(gc.getInput().getMouseX(), gc.getInput().getMouseY());
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		input.input(gc, sbg, this, delta);
	}

	@Override
	public int getID() {
		return Game.ID;
	}

}
