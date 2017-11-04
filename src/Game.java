import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {

	public static final int ID = 1;
	
	private StateBasedGame game;
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.game = sbg;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setColor(Color.red);
		g.fillRect(0, 0, Start.WIDTH, Start.HEIGHT);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delay) throws SlickException {
		
	}

	@Override
	public int getID() {
		return Game.ID;
	}

}
