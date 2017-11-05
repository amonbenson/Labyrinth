package game;
import java.awt.Dimension;
import java.awt.Toolkit;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

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
	public static int TARGET_FPS = 120;
	
	public Main(String title) {
		super(title);
	}

	public static void main(String[] args)  {
		try {
			AppGameContainer game = new AppGameContainer(new ScalableGame(new Main(NAME), WIDTH, HEIGHT));
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
		
		enterState(MainMenu.ID);
	}

}
