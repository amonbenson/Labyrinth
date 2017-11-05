package mainMenu;

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

public class MainMenu extends BasicGameState{

	public static final int ID = 0;
	ArrayList<Rectangle> rectangleList;
	int buttonWidth =512;
	int buttonHeight= 128;
	
	int chosenButton = 0;
	
	public MainMenu() {
		
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		rectangleList = new ArrayList<Rectangle>();
		rectangleList.add(new Rectangle(704,540,buttonWidth,buttonHeight));
		rectangleList.add(new Rectangle(704,720,buttonWidth,buttonHeight) );
		rectangleList.add(new Rectangle(704,900,buttonWidth,buttonHeight) );
		
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
		Database.FNT_BUTTON.drawString(rec.x + rec.width/2 - Database.FNT_BUTTON.getWidth("Spielen")/2,rec.y + rec.height/2 -(Database.FNT_BUTTON.getHeight("Spielen")/2), "Spielen");
		rec = rectangleList.get(1);
		Database.FNT_BUTTON.drawString(rec.x + rec.width/2 - Database.FNT_BUTTON.getWidth("Einstellung")/2,rec.y + rec.height/2 - (Database.FNT_BUTTON.getHeight("Einstellung")/2), "Einstellung");
		rec = rectangleList.get(2);
		Database.FNT_BUTTON.drawString(rec.x + rec.width/2 - Database.FNT_BUTTON.getWidth("Ende")/2,rec.y + rec.height/2 - (Database.FNT_BUTTON.getHeight("Ende")/2), "Ende");
	
	
	
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		if(gc.getInput().isKeyPressed(Input.MOUSE_LEFT_BUTTON)){
		
		}			
		if(gc.getInput().isKeyPressed(Input.KEY_S)||gc.getInput().isKeyPressed(Input.KEY_DOWN))
			chosenButton++;
		if(gc.getInput().isKeyPressed(Input.KEY_W)||gc.getInput().isKeyPressed(Input.KEY_UP))
			chosenButton--;
		
		
		if(chosenButton<0)
			chosenButton = rectangleList.size()-1;
		if(chosenButton>=rectangleList.size())
			chosenButton = 0;
		
		if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){
			
			if (chosenButton==0){
				sbg.enterState(levelSelect.LevelSelect.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.white));
			}
			if (chosenButton==1){
				
			}
			if (chosenButton==2){
				System.out.println("> Bye from the console! Was a pleasure to show you no errors.");
				gc.exit();
			}
		}
			
		
	}
	
	@Override
	public int getID() {
		return ID;
	}

}
