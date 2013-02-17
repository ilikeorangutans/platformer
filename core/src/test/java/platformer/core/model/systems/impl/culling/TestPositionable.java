package platformer.core.model.systems.impl.culling;

import platformer.core.model.systems.Positionable;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class TestPositionable implements Positionable {

	private Vector3 position = new Vector3(0, 0, 0);
	private Rectangle bounds = new Rectangle(0, 0, 0, 0);

	public TestPositionable(int x, int y) {
		this(x, y, x, y, 1, 1);
	}

	public TestPositionable(int x, int y, int boundx, int boundy, int width, int height) {
		this(new Vector3(x, y, 0), new Rectangle(boundx, boundy, width, height));
	}

	public TestPositionable(Vector3 position, Rectangle bounds) {
		this.position = position;
		this.bounds = bounds;
	}

	@Override
	public void setPosition(Vector3 position) {
		this.position = position;
	}

	@Override
	public Vector3 getPosition() {
		return position;
	}

	@Override
	public Rectangle getBounds() {
		return bounds;
	}

}
