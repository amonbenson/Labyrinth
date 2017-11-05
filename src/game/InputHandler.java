package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import score.ScoreScreen;

public class InputHandler {
	public void input(GameContainer gc, StateBasedGame sbg, Game game, int delta) {

		
		if (Game.isDone) {
			Game.isDone = false;
			ScoreScreen.score = game.level.moves;
			game.level.reset();
			Main.mainGame.transitState(ScoreScreen.ID);
		}
		
		
		

		if (gc.getInput().isKeyPressed(Input.KEY_TAB)) {
			if (gc.getInput().isKeyDown(Input.KEY_LSHIFT)) {
				// SHIFT
				game.currentIndexSelecting--;
				if (game.currentIndexSelecting < 0) {
					game.currentIndexSelecting = game.maxIndex - 1;
				}
				if (game.currentIndexSelecting != 0) {
					game.colorSelectID = game.level.usedColors[game.currentIndexSelecting - 1];
				} else {
					game.colorSelectID = -1;
				}
			} else {
				// NICHT SHIFT (normal)
				game.currentIndexSelecting++;
				if (game.currentIndexSelecting >= game.maxIndex) {
					game.currentIndexSelecting = 0;
				}

				if (game.currentIndexSelecting != 0) {
					game.colorSelectID = game.level.usedColors[game.currentIndexSelecting - 1];
				} else {
					game.colorSelectID = -1;
				}
			}
		}

		// Move the player / colored tile and start the tile animation
		if (gc.getInput().isKeyPressed(Input.KEY_UP) || gc.getInput().isKeyPressed(Input.KEY_W)) {
			if (game.currentIndexSelecting == game.selectPlayer) {
				game.level.movePlayerUp();
			} else {
				game.level.moveUp(game.level.usedColors[game.currentIndexSelecting - 1]);
			}
			game.renderer.startTileAnimation();
		} else if (gc.getInput().isKeyPressed(Input.KEY_DOWN) || gc.getInput().isKeyPressed(Input.KEY_S)) {
			if (game.currentIndexSelecting == game.selectPlayer) {
				game.level.movePlayerDown();
			} else {
				game.level.moveDown(game.level.usedColors[game.currentIndexSelecting - 1]);
			}
			game.renderer.startTileAnimation();
		} else if (gc.getInput().isKeyPressed(Input.KEY_LEFT) || gc.getInput().isKeyPressed(Input.KEY_A)) {
			if (game.currentIndexSelecting == game.selectPlayer) {
				game.level.movePlayerLeft();
			} else {
				game.level.moveLeft(game.level.usedColors[game.currentIndexSelecting - 1]);
			}
			game.renderer.startTileAnimation();
		} else if (gc.getInput().isKeyPressed(Input.KEY_RIGHT) || gc.getInput().isKeyPressed(Input.KEY_D)) {
			if (game.currentIndexSelecting == game.selectPlayer) {
				game.level.movePlayerRight();
			} else {
				game.level.moveRight(game.level.usedColors[game.currentIndexSelecting - 1]);
			}
			game.renderer.startTileAnimation();
		}

	}
}
