package game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

public class InputHandler {
	public void input(GameContainer gc, StateBasedGame sbg, Game game, int delta) {
		
		int selectedID = StoneMoveable.RED;
		
		if (gc.getInput().isKeyPressed(Input.KEY_TAB)) {
			if (gc.getInput().isKeyPressed(Input.KEY_LSHIFT)) {
				//SHIFT
				game.currentIndexSelecting--;
				if (game.currentIndexSelecting < 0) {
					game.currentIndexSelecting = game.maxIndex-1;
				}
			} else {
				//NICHT SHIFT (normal)
				game.currentIndexSelecting++;
				if (game.currentIndexSelecting >= game.maxIndex) {
					game.currentIndexSelecting = 0;
				}
			}
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_UP) || gc.getInput().isKeyPressed(Input.KEY_W)) {
			game.level.moveUp(selectedID);
		} else if (gc.getInput().isKeyPressed(Input.KEY_DOWN) || gc.getInput().isKeyPressed(Input.KEY_S)) {
			game.level.moveDown(selectedID);			
		} else if (gc.getInput().isKeyPressed(Input.KEY_LEFT) || gc.getInput().isKeyPressed(Input.KEY_A)) {
			game.level.moveLeft(selectedID);
		} else if (gc.getInput().isKeyPressed(Input.KEY_RIGHT) || gc.getInput().isKeyPressed(Input.KEY_D)) {
			game.level.moveRight(selectedID);
		}
		
		
		
	}
}
