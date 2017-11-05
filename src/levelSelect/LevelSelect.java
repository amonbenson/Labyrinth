package levelSelect;

import java.awt.Rectangle;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import game.Database;
import game.GUITools;
import game.Game;
import game.LevelLoader;
import game.Main;
import mainMenu.MainMenu;

public class LevelSelect extends BasicGameState {

	public static final int ID = 1;
	
	Rectangle[] buttons;
	String[] buttonTexts;
	int chosenButton = 0;
	
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		buttonTexts = new String[] {"Tutorial", "Level 1", "Level 2", "Level 3", "Level 4"};
		buttons = GUITools.generateCenteredGUIButtons(buttonTexts.length, 300, GUITools.DEFAULT_BTN_WIDTH, GUITools.DEFAULT_SMALL_BTN_HEIGHT, GUITools.DEFAULT_BTN_SPACE);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(Database.IMG_GUI_MAINMENU_BACKGROUND, 0, 0); 
		
		GUITools.renderGUIButtons(g, buttons, buttonTexts, chosenButton);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
			Main.mainGame.switchState(MainMenu.ID);
		}
		
		
			if(gc.getInput().isKeyPressed(Input.KEY_S)||gc.getInput().isKeyPressed(Input.KEY_DOWN))
				chosenButton++;
			if(gc.getInput().isKeyPressed(Input.KEY_W)||gc.getInput().isKeyPressed(Input.KEY_UP))
				chosenButton--;

		if(chosenButton<0)
			chosenButton = buttons.length-1;
		if(chosenButton>=buttons.length)
			chosenButton = 0;
		
		if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){
			if (chosenButton==0){
				Game.level = LevelLoader.getTutorialLevel();
			}
			if (chosenButton==1){
				Game.level = LevelLoader.getLevelOne();
			}
			if (chosenButton==2){
				Game.level = LevelLoader.getLevelTwo();
			}
			if (chosenButton==3) {
				Game.level = LevelLoader.getLevelThree();
			}
			if (chosenButton==4) {
				Game.level = LevelLoader.getLevelFour();
			}
			
			Main.mainGame.switchState(Game.ID);
		}
			
		
		
	}

	@Override
	public int getID() {
		return ID;
	}

}
