package levelEditor;


import java.awt.Font;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import game.Database;
import game.GameRenderer;
import game.TileTransform;
import game.Level;
public class EditorMain extends BasicGameState{

	private StateBasedGame game;
	private InputHandler inp;
	private int lastMouseX = -20, lastMouseY = -10;
	private GameRenderer rend;
	private Level lvl;
	private TileTransform trans;
	private TrueTypeFont f;
	
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		game = arg1;
		inp = new InputHandler(this);
		arg0.getInput().addMouseListener(inp);
		rend = new GameRenderer();
		lvl = new Level(5, 5, 0, 0, 4, 4);
		trans = new TileTransform(0, 50, 1000/lvl.width, 1000/lvl.height);
		// initialise the font
		Font font = new Font("Verdana", Font.BOLD, 30);
		f = new TrueTypeFont(font, true);
	}

	public void render(GameContainer gc, StateBasedGame arg1, Graphics gr) throws SlickException {
		
		// TODO Auto-generated method stub
		gr.setColor(Color.lightGray);
		gr.fillRect(0, 0, 10000, 10000);
		gr.setColor(Color.red);
		gr.fillOval(lastMouseX-5, lastMouseY-5, 10, 10);
		
		//Draw Tiles
		gr.pushTransform();
		trans.applyToGraphics(gr);
		rend.renderTilesFromLevel(gr, lvl);
		gr.popTransform();

		// render some text to the screen
		f.drawString(1000f, 100.0f, "Größe: ", Color.black);
		f.drawString(1150f, 100.0f, "5", Color.black);
		Database.IMG_STONE_MOVABLE.draw(1200, 90, 0.2f, Color.white);
		Database.IMG_STONE_MOVABLE.draw(1250, 90, 0.2f, Color.white);
		f.drawString(1210, 95, "+");
		f.drawString(1265, 95, "-");
		f.drawString(1000f, 200.0f, "Spielelemente: ", Color.black);
		
		Database.IMG_FINISH.draw(1050,250,3f,Color.white);
		Database.IMG_PLAYER.draw(1250,250,3f,Color.white);
		Database.IMG_STONE_MOVABLE.draw(1050,500,0.5f,Color.white);
		Database.IMG_STONE_MOVABLE.draw(1200,500,0.5f,Color.red);
		Database.IMG_STONE_MOVABLE.draw(1350,500,0.5f,Color.blue);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		System.out.println("Maus bei x: "+gc.getInput().getMouseX()+" y: "+gc.getInput().getMouseY());
	}
	
	public void mouseClicked (int x, int y, int z, int a) {
		System.out.println(y);
	}
	public void Click(int x, int y){
		lastMouseX = x;
		lastMouseY = y;
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
