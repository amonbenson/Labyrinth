package game;

import java.awt.Rectangle;

import org.newdawn.slick.Graphics;

public class GUITools {

	public static final float DEFAULT_BTN_WIDTH = 512;
	
	public static final float DEFAULT_BTN_HEIGHT = 128;
	public static final float DEFAULT_SMALL_BTN_HEIGHT = 80;
	
	public static final float DEFAULT_BTN_SPACE = 32;
	
	public static Rectangle[] generateCenteredGUIButtons(int number, float y, float btnWidth, float btnHeight, float btnSpace) {
		return generateGUIButtons(number, (Main.WIDTH - btnWidth) / 2, y, btnWidth, btnHeight, btnSpace);
	}
	
	public static Rectangle[] generateGUIButtons(int number, float x, float y, float btnWidth, float btnHeight, float btnSpace) {
		Rectangle[] buttons = new Rectangle[number];
		
		for (int i = 0; i < buttons.length; i++) {
			float btnX = x;
			float btnY = y + i * (btnHeight + btnSpace);
			
			buttons[i] = new Rectangle((int) btnX, (int) btnY, (int) btnWidth, (int) btnHeight);
		}
		
		return buttons;
	}
	
	public static void renderGUIButtons(Graphics g, Rectangle[] buttons, String[] texts, int chosenButton) {
		if (buttons.length != texts.length) throw new IllegalArgumentException("buttons and text must be of the same array length!");
		
		for (int i = 0; i < buttons.length; i++) {
			Rectangle b = buttons[i];
			String t = texts[i];
			
			// Draw the button
			if (i != chosenButton) {
				Database.IMG_GUI_BUTTON.draw(b.x, b.y, b.width, b.height);
			} else {
				Database.IMG_GUI_BUTTON_CHOSEN.draw(b.x, b.y, b.width, b.height);
			}
			
			// Draw the text
			Database.FNT_BUTTON.drawString(
					b.x + (b.width - Database.FNT_BUTTON.getWidth(t)) / 2,
					b.y + (b.height -Database.FNT_BUTTON.getHeight(t)) / 2,
					t
			);
		}
	}
}