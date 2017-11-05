package game;

public class Tile implements Cloneable {
	public int x, y;
	
	public boolean isAnimating;
	public int lastX, lastY; // Used for the animation
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Tile(Tile t) {
		this.x = t.x;
		this.y = t.y;
	}
	
	@Override
	public Tile clone() {
		return new Tile(x, y);
	}
	
	public float getAnimatedX(float factor) {
		return lastX + (x - lastX) * factor;
	}
	
	public float getAnimatedY(float factor) {
		return lastY + (y - lastY) * factor;
	}
	
	public void startAnimation() {
		startAnimation(x, y);
	}
	
	public void startAnimation(int lastX, int lastY) {
		this.lastX = lastX;
		this.lastY = lastY;
		isAnimating = true;
	}
}
