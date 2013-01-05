package platformer.core.model.gameobject.impl;

import platformer.core.model.GameObject;
import platformer.core.model.Positionable;
import platformer.core.model.Renderable;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class LevelTile implements GameObject, Positionable, Renderable {

	private final Vector3 position;
	private final Rectangle bounds;
	private ShapeRenderer renderer;

	public LevelTile(Vector3 position, Rectangle bounds) {
		this.position = position;
		this.bounds = bounds;
		renderer = new ShapeRenderer();
	}

	@Override
	public Vector3 getPosition() {
		return position;
	}

	@Override
	public Rectangle getBounds() {
		return bounds;
	}

	@Override
	public boolean canBeRemoved() {
		return false;
	}

	@Override
	public void dispose() {
	}

	@Override
	public void update() {
	}

	@Override
	public void render(Graphics graphics) {
		renderer.begin(ShapeType.FilledRectangle);
		renderer.setColor(1, 1, 1, 1);
		renderer.filledRect(position.x, position.y, bounds.width, bounds.height);
		renderer.end();
	}


}
