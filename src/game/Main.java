package game;
import java.awt.Dimension;
import java.awt.Toolkit;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import levelSelect.LevelSelect;
import mainMenu.MainMenu;
//import LevelEditor.EditorMain;
import score.ScoreScreen;
import levelEditor.EditorMain;


public class Main extends StateBasedGame {

	public static final String NAME = "Labyrinth";
	
	public static int WIDTH = 1920;
	public static int HEIGHT = 1080;

	public static boolean FULLSCREEN = true;
	public static boolean MOUSE_GRABBED = true;
	public static boolean DEBUG_START = false;
	public static int TARGET_FPS = 120;
	
	public static Main mainGame;
	
	public Main() {
		super(NAME);
	}

	public static void main(String[] args)  {
		try {
			mainGame = new Main();
			AppGameContainer game = new AppGameContainer(new ScalableGame(mainGame, WIDTH, HEIGHT));
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			if (!FULLSCREEN) {
				screen.width /= 2;
				screen.height /= 2;
			}
			game.setDisplayMode(screen.width, screen.height, FULLSCREEN);
			game.setClearEachFrame(true);
			game.setMouseGrabbed(MOUSE_GRABBED);
			game.setShowFPS(false);
			game.setTargetFrameRate(TARGET_FPS);
			game.start();
		} catch (SlickException se) {
			se.printStackTrace();
			System.exit(1);
		}
	}


	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		// Initialize the database (loud all ressources)
		Database.init();
		
		// Start the main music loop
		Database.SND_MUSIC_TITLE.loop();
		
		//Hier fügen wir die Menüs hinzu
		this.addState(new MainMenu());//Hier fügen wir die Menüs hinzu
		this.addState(new LevelSelect());
		this.addState(new EditorMain());//Editor
		this.addState(new Game()); //Das erste hinzugefügte GameState wird automatisch geladen
		this.addState(new ScoreScreen());
		
		if (DEBUG_START) {
			Game.level = LevelLoader.getLevelTwo();
			enterState(Game.ID);
		} else {
			enterState(MainMenu.ID);
		}
	}

	/**
	 * Custom method to switch a state, so that all transitions look the same and the code style is more objective.
	 * 
	 * @param newStateID
	 */
	public void transitState(int newStateID) {
		enterState(newStateID, new FadeOutTransition(GameRenderer.BACKGROUND_COLOR), new FadeInTransition(GameRenderer.BACKGROUND_COLOR));
	}
}
