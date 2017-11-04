import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState{

	static final int ID = 10;
	ArrayList<Rectangle> rectangleList;
	int buttonWidth =512;
	int buttonHeight= 128;
	
	int chosenButton = 0;
	
	public MainMenu() {
		
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		rectangleList = new ArrayList<Rectangle>();
		rectangleList.add(new Rectangle(704,540,buttonWidth,buttonHeight) );
		rectangleList.add(new Rectangle(704,360,buttonWidth,buttonHeight) );
		rectangleList.add(new Rectangle(704,180,buttonWidth,buttonHeight) );
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(Database.IMG_GUI_MAINMENU_BACKGROUND, 0, 0); 
		
		int counter = 0;
		
		for (Rectangle rec : rectangleList){
			if (counter == chosenButton){
				g.drawImage(Database.IMG_GUI_BUTTON_CHOSEN,rec.x,rec.y);
			}
			counter ++;
		}
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		if(gc.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
		
		}			
		
		if(gc.getInput().isKeyDown(Input.KEY_S)||gc.getInput().isKeyDown(Input.KEY_DOWN))
			chosenButton++;
		if(gc.getInput().isKeyDown(Input.KEY_W)||gc.getInput().isKeyDown(Input.KEY_UP))
			chosenButton--;
		
		if(chosenButton<0)
			chosenButton = rectangleList.size();
		if(chosenButton>=rectangleList.size())
			chosenButton = 0;
	}

	@Override
	public int getID() {
		return ID;
	}

}
