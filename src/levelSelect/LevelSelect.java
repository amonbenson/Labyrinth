package levelSelect;

import java.awt.Rectangle;
import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import game.Database;
import game.Game;
import game.LevelLoader;

public class LevelSelect extends BasicGameState {

	public static final int ID = 56;
	
	int chosenButton = 0;
	
	ArrayList<Rectangle> rectangleList;
	int buttonWidth =512;
	int buttonHeight= 80;
	
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		rectangleList = new ArrayList<Rectangle>();
		
		rectangleList.add(new Rectangle(704,300, buttonWidth, buttonHeight));
		rectangleList.add(new Rectangle(704,400, buttonWidth, buttonHeight));
		rectangleList.add(new Rectangle(704,500,buttonWidth,buttonHeight));
		rectangleList.add(new Rectangle(704,600,buttonWidth,buttonHeight) );
		rectangleList.add(new Rectangle(704,700,buttonWidth,buttonHeight) );
		//rectangleList.add(new Rectangle(704,800, buttonWidth, buttonHeight));
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(Database.IMG_GUI_MAINMENU_BACKGROUND, 0, 0); 
		
		
		
		int counter = 0;
		
		for (Rectangle rec : rectangleList){
			if (counter == chosenButton)
				Database.IMG_GUI_BUTTON_CHOSEN.draw(rec.x,rec.y, rec.width, rec.height);
			else
				Database.IMG_GUI_BUTTON.draw(rec.x,rec.y, rec.width,rec.height);
			
			counter ++;
		}
		Rectangle rec = rectangleList.get(0);
		Database.FNT_BUTTON.drawString(rec.x + rec.width/2 - Database.FNT_BUTTON.getWidth("Tutorial")/2,rec.y + rec.height/2 -(Database.FNT_BUTTON.getHeight("Tutorial")/2), "Tutorial");
		rec = rectangleList.get(1);
		Database.FNT_BUTTON.drawString(rec.x + rec.width/2 - Database.FNT_BUTTON.getWidth("Level 1")/2,rec.y + rec.height/2 - (Database.FNT_BUTTON.getHeight("Level 1")/2), "Level 1");
		rec = rectangleList.get(2);
		Database.FNT_BUTTON.drawString(rec.x + rec.width/2 - Database.FNT_BUTTON.getWidth("Level 2")/2,rec.y + rec.height/2 - (Database.FNT_BUTTON.getHeight("Level 2")/2), "Level 2");
		rec = rectangleList.get(3);
		Database.FNT_BUTTON.drawString(rec.x + rec.width/2 - Database.FNT_BUTTON.getWidth("Level 3")/2,rec.y + rec.height/2 - (Database.FNT_BUTTON.getHeight("Level 3")/2), "Level 3");
		rec = rectangleList.get(4);
		Database.FNT_BUTTON.drawString(rec.x + rec.width/2 - Database.FNT_BUTTON.getWidth("Level 4")/2,rec.y + rec.height/2 - (Database.FNT_BUTTON.getHeight("Level 4")/2), "Level 4");
		//rec = rectangleList.get(5);
		//Database.FNT_BUTTON.drawString(rec.x + rec.width/2 - Database.FNT_BUTTON.getWidth("Level 5")/2,rec.y + rec.height/2 - (Database.FNT_BUTTON.getHeight("Level 5")/2), "Level 5");

	
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		if(gc.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
		
		}			
		

			if(gc.getInput().isKeyPressed(Input.KEY_S)||gc.getInput().isKeyPressed(Input.KEY_DOWN))
				chosenButton++;
			if(gc.getInput().isKeyPressed(Input.KEY_W)||gc.getInput().isKeyPressed(Input.KEY_UP))
				chosenButton--;

		if(chosenButton<0)
			chosenButton = rectangleList.size()-1;
		if(chosenButton>=rectangleList.size())
			chosenButton = 0;
		
		if(gc.getInput().isKeyDown(Input.KEY_ENTER)){
			if (chosenButton==0){
				Game.level = LevelLoader.getTutorialLevel();
				sbg.enterState(game.Game.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.white));
			}
			if (chosenButton==1){
				Game.level = LevelLoader.getLevelOne();
				sbg.enterState(game.Game.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.white));
			}
			if (chosenButton==2){
				Game.level = LevelLoader.getLevelTwo();
				sbg.enterState(game.Game.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.white));
			}
			if (chosenButton==3) {
				Game.level = LevelLoader.getLevelThree();
				sbg.enterState(game.Game.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.white));
			}
			if (chosenButton==4) {
				Game.level = LevelLoader.getLevelFour();
				sbg.enterState(game.Game.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.white));
			}
			//if (chosenButton==5) {
				
				//sbg.enterState(game.Game.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.white));
			//}
		}
			
		
		
	}

	@Override
	public int getID() {
		return ID;
	}

}
