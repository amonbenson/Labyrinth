import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

public class InputHandler {
	public void input(GameContainer gc, StateBasedGame sbg, Game game, int delta) {
		
		int selectedID = StoneMoveable.RED;
		
		if (gc.getInput().isKeyPressed(Input.KEY_UP)) {
			game.level.moveUp(selectedID);
		} else if (gc.getInput().isKeyPressed(Input.KEY_DOWN)) {
			game.level.moveDown(selectedID);			
		} else if (gc.getInput().isKeyPressed(Input.KEY_LEFT)) {
			game.level.moveLeft(selectedID);
		} else if (gc.getInput().isKeyPressed(Input.KEY_RIGHT)) {
			game.level.moveRight(selectedID);
		}
		
	}
}
