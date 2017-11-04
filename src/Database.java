import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Database {

	public static final String IMAGE_PATH = "res/img/";

	public static Image IMG_GUI_BUTTON;
	public static Image IMG_GUI_BUTTON_CHOSEN;
	
	public static Image IMG_STONE;
	public static Image IMG_STONE_MOVABLE;
	public static Image IMG_STONE_MOVABLE_CHOSEN;
	public static Image IMG_TILE;

	public static Image IMG_FINISH;
	
	public static void init() {
		//TODO REMOVE!!!
		
		// Load all the images
		IMG_GUI_BUTTON = loadImage("button.png");
		IMG_GUI_BUTTON_CHOSEN = loadImage("buttonChosen.png");
		
		IMG_STONE = loadImage("stone.png");
		IMG_STONE_MOVABLE = loadImage("stoneMoveable.png");
		IMG_TILE = loadImage("tile.png");
		
		IMG_FINISH = loadImage("finish.png");
		
	}
	
	public static Image loadImage(String name) {
		try {
			return new Image(IMAGE_PATH + name);
		} catch (SlickException e) {
			System.err.println("Failed to load resource " + name + "!");
			e.printStackTrace();
		}
		
		return null;
	}
}
