package game;

import org.newdawn.slick.Font;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

public class Database {

	public static final String IMAGE_PATH = "res/img/";

	public static Image IMG_GUI_BUTTON;
	public static Image IMG_GUI_BUTTON_CHOSEN;
	
	public static Image IMG_STONE;
	public static Image IMG_STONE_MOVABLE;
	public static Image IMG_STONE_MOVABLE_CHOSEN;
	public static Image IMG_TILE;

	public static Image IMG_PLAYER;	
	public static Image IMG_FINISH;
	
	public static Font FNT_DEFAULT;
	
	public static void init() {
		// Load all the images
		IMG_GUI_BUTTON = loadImage("button.png");
		IMG_GUI_BUTTON_CHOSEN = loadImage("buttonChosen.png");
		
		IMG_STONE = loadImage("stone.png");
		IMG_STONE_MOVABLE = loadImage("stoneMoveable.png");
		IMG_STONE_MOVABLE_CHOSEN = loadImage("stoneMoveableChosen.png");
		IMG_TILE = loadImage("tile.png");
		
		IMG_PLAYER = loadImage("player.png");
		IMG_FINISH = loadImage("finish.png");
		
		// Load the font
		//FNT_DEFAULT = 
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
	
	/*
	public static Font loadFont(String name) {
		
	}*/
}
