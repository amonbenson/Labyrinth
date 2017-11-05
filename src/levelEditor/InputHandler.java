package levelEditor;

import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

public class InputHandler implements MouseListener{

	private EditorMain fenster;
	public InputHandler(EditorMain _fenster){
		fenster = _fenster;
	}
	public void inputEnded() {
		// TODO Auto-generated method stub
		
	}

	public void inputStarted() {
		// TODO Auto-generated method stub
		
	}

	public boolean isAcceptingInput() {
		// TODO Auto-generated method stub
		return true;
	}

	public void setInput(Input arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(int arg0, int x, int y, int arg3) {
		// TODO Auto-generated method stub
		System.out.println("Klickevent bei: "+x+", "+y+" arg0: "+arg0+" arg3"+arg3);
		fenster.Click(x, y);
		
	}

	public void mouseDragged(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	public void mouseWheelMoved(int arg0) {
		// TODO Auto-generated method stub
		
	}


}
