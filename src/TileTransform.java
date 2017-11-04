import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;

public class TileTransform {
	
	public float x, y;
	public float sx, sy;
	
	public TileTransform() {
		this(0, 0, 1, 1);
	}
	
	public TileTransform(float x, float y, float sx, float sy) {
		this.x = x;
		this.y = y;
		this.sx = sx;
		this.sy = sy;
	}
	
	public void applyToGraphics(Graphics g) {
		g.translate(x, y);
		g.scale(sx, sy);
	}
	
	public Point getTilePosition(float mx, float my) {
		Point p = new Point((mx - x) / sx, (my - y) / sy);
		return p;
	}
}
