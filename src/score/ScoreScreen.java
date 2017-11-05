package score;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import game.Database;
import game.Main;

public class ScoreScreen extends BasicGameState {
	public static final int ID = 23;

	public static int score;
	
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//g.setColor(new Color(116, 188, 154));
		//g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
		Database.FNT_DEFAULT.drawString(Main.WIDTH/2f-Database.FNT_DEFAULT.getWidth("Du hast das Level geschafft!!"), Main.HEIGHT/2f-Main.HEIGHT/4f, "Du hast das Level geschafft!!");
		Database.FNT_DEFAULT.drawString(Main.WIDTH/2f-Database.FNT_DEFAULT.getWidth("Deine Anzahl an Zuegen: "+score), Main.HEIGHT/2f, "Deine Anzahl an Zuegen: "+score);
		Database.FNT_DEFAULT.drawString(Main.WIDTH/2f-Database.FNT_DEFAULT.getWidth("Drücke Enter um zum Hauptmenu zu gelangen"), Main.HEIGHT/2f+Main.HEIGHT/4f, "Drücke Enter um zum Hauptmenue zu gelangen");
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if(gc.getInput().isKeyDown(Input.KEY_ENTER)) {
			//sbg.enterState(, leave, enter);
		}
		
	}

	@Override
	public int getID() {
		return ID;
	}
	
}
