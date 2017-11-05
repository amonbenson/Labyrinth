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
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.game = sbg;
		
		tileTransform = new TileTransform();
		
		renderer = new GameRenderer();
		input = new InputHandler();
		
		level = LevelLoader.getDefaultLevel();
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		renderer.render(gc, sbg, this, g);
		
		Point p = tileTransform.getTilePosition(gc.getInput().getMouseX(), gc.getInput().getMouseY());
		
		//g.setFont
		g.drawString(p.getX() + ", " + p.getY(), 100, 100);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		input.input(gc, sbg, this, delta);
	}

	@Override
	public int getID() {
		return Game.ID;
	}

}
