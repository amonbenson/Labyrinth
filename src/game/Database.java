package game;

import org.newdawn.slick.Font;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

public class Database {

	public static final String IMAGE_PATH = "res/img/";
	public static final String SOUND_PATH = "res/snd/";
	public static final String FONT_PATH = "res/fnt/";

	public static Image IMG_GUI_BUTTON;
	public static Image IMG_GUI_BUTTON_CHOSEN;

	public static Image IMG_STONE;
	public static Image IMG_STONE_MOVABLE;
	public static Image IMG_STONE_MOVABLE_CHOSEN;
	public static Image IMG_TILE;

	public static Image IMG_PLAYER;
	public static Image IMG_FINISH;

	public static Music SND_MUSIC_TITLE;
	public static Music SND_BUTTON;
	public static Music SND_WIN;

	public static Font FNT_DEFAULT;
	public static Font FNT_BUTTON;

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
		
		// Load the music / sounds
		SND_MUSIC_TITLE = loadMusic("musicTitle.ogg");
		
		// Load the font
		FNT_DEFAULT = loadFont("default.ttf", 22);
		FNT_BUTTON = loadFont("default.ttf", 30);
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
	
	public static Music loadMusic(String name) {
		try {
			return new Music(SOUND_PATH + name);
		} catch (SlickException e) {
			System.err.println("Failed to load resource " + name + "!");
			e.printStackTrace();
		}

		return null;
	}

	public static Font loadFont(String name, float size) {
		try {
			java.awt.Font javaFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT,
					org.newdawn.slick.util.ResourceLoader.getResourceAsStream(FONT_PATH + name));
			javaFont = javaFont.deriveFont(size);
			Font font = new TrueTypeFont(javaFont, false);
			
			return font;
		} catch (Exception e) {
			System.err.println("Failed to load resource " + name + "!");
			e.printStackTrace();
		}

		return null;
	}
}
