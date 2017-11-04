import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {

	public static final int ID = 1;
	
	private StateBasedGame game;
	private GameRenderer renderer;
	private InputHandler input;
	
	public Level level = null; //das aktuelle Level mit allen interessanten Daten
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.game = sbg;
		renderer = new GameRenderer();
		input = new InputHandler();
		level = LevelLoader.getDefaultLevel();
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		renderer.render(gc, sbg, this, g);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		input.input(gc, sbg, this, delta);
	}

	@Override
	public int getID() {
		return Game.ID;
	}

}
