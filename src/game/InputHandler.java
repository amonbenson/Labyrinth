package game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.CrossStateTransition;
import org.newdawn.slick.state.transition.EmptyTransition;

import score.ScoreScreen;

public class InputHandler {
	public void input(GameContainer gc, StateBasedGame sbg, Game game, int delta) {
		
		if (Game.isDone) {
			Game.isDone = false;
			ScoreScreen.score = game.level.moves;
			
			final long start = System.currentTimeMillis();
			CrossStateTransition t = new CrossStateTransition(sbg.getState(ScoreScreen.ID)) {				
				public boolean isComplete() {
					return (System.currentTimeMillis() - start) > 1000;
				}

				public void init(GameState firstState, GameState secondState) {
				}
			};
			sbg.enterState(ScoreScreen.ID, t, new EmptyTransition());
		}
		
		
		
		if (gc.getInput().isKeyPressed(Input.KEY_TAB)) {
			if (gc.getInput().isKeyDown(Input.KEY_LSHIFT)) {
				//SHIFT
				game.currentIndexSelecting--;
				if (game.currentIndexSelecting < 0) {
					game.currentIndexSelecting = game.maxIndex-1;
				}
				if (game.currentIndexSelecting != 0) {
					game.colorSelectID = game.level.usedColors[game.currentIndexSelecting-1];
				} else {
					game.colorSelectID = -1;
				}
			} else {
				//NICHT SHIFT (normal)
				game.currentIndexSelecting++;
				if (game.currentIndexSelecting >= game.maxIndex) {
					game.currentIndexSelecting = 0;
				}
				
				if (game.currentIndexSelecting != 0) {
					game.colorSelectID = game.level.usedColors[game.currentIndexSelecting-1];
				} else {
					game.colorSelectID = -1;
				}
			}
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_UP) || gc.getInput().isKeyPressed(Input.KEY_W)) {
			if (game.currentIndexSelecting == game.selectPlayer) {
				game.level.movePlayerUp();
			} else {
				game.level.moveUp(game.level.usedColors[game.currentIndexSelecting-1]);
			}
		} else if (gc.getInput().isKeyPressed(Input.KEY_DOWN) || gc.getInput().isKeyPressed(Input.KEY_S)) {
			if (game.currentIndexSelecting == game.selectPlayer) {
				game.level.movePlayerDown();
			} else {
				game.level.moveDown(game.level.usedColors[game.currentIndexSelecting-1]);			
			}
		} else if (gc.getInput().isKeyPressed(Input.KEY_LEFT) || gc.getInput().isKeyPressed(Input.KEY_A)) {
			if (game.currentIndexSelecting == game.selectPlayer) {
				game.level.movePlayerLeft();
			} else {
				game.level.moveLeft(game.level.usedColors[game.currentIndexSelecting-1]);			
			}
		} else if (gc.getInput().isKeyPressed(Input.KEY_RIGHT) || gc.getInput().isKeyPressed(Input.KEY_D)) {
			if (game.currentIndexSelecting == game.selectPlayer) {
				game.level.movePlayerRight();
			} else {
				game.level.moveRight(game.level.usedColors[game.currentIndexSelecting-1]);			
			}
		}
		
		
		
	}
}
