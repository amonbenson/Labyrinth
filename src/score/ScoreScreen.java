package score;

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
import game.Main;

public class ScoreScreen extends BasicGameState {
	public static final int ID = 23;

	public static int score;
	
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setColor(new Color(116, 188, 154));
		g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
		Database.FNT_TITLE.drawString(Main.WIDTH/2f-Database.FNT_TITLE.getWidth("Du hast das Level geschafft (Ausrufezeichen, die gibt es in der Font nicht)")/2f, Main.HEIGHT/2f-Main.HEIGHT/4f, "Du hast das Level geschafft (Ausrufezeichen, die gibt es in der Font nicht)");
		Database.FNT_TITLE.drawString(Main.WIDTH/2f-Database.FNT_TITLE.getWidth("Deine Anzahl an Zuegen ist "+score)/2f, Main.HEIGHT/2f, "Deine Anzahl an Zuegen ist "+score);
		Database.FNT_TITLE.drawString(Main.WIDTH/2f-Database.FNT_TITLE.getWidth("Druecke Space um zum Hauptmenu zu gelangen")/2f, Main.HEIGHT/2f+Main.HEIGHT/4f, "Druecke Space um zum Hauptmenue zu gelangen");
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if(gc.getInput().isKeyDown(Input.KEY_SPACE)) {
			sbg.enterState(mainMenu.MainMenu.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.white));
		}
		
	}

	@Override
	public int getID() {
		return ID;
	}
	
}
