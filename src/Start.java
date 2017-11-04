import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Start extends StateBasedGame {

	public static final String NAME = "Labyrinth";
	
	public static int WIDTH = 1920;
	public static int HEIGHT = 1080;
	public static boolean FULLSCREEN = false;
	
	public Start(String title) {
		super(title);
		
	}

	public static void main(String[] args)  {
		try {
			AppGameContainer game = new AppGameContainer(new Start(NAME));
			game.setDisplayMode(WIDTH, HEIGHT, FULLSCREEN);
			game.start();
		} catch (SlickException se) {
			se.printStackTrace();
			System.exit(1);
		}
	}


	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		//Hier fügen wir die Menüs hinzu
		this.addState(new Game()); //Das erste hinzugefügte GameState wird automatisch geladen
	}

}
