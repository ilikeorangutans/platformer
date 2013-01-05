package platformer.core.model.gameobject.impl;

import platformer.core.model.GameObject;
import platformer.core.model.Positionable;
import platformer.core.model.Renderable;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class LevelTile implements GameObject, Positionable, Renderable {

	private final Vector3 position;
	private final Rectangle bounds;

	public LevelTile(Vector3 position, Rectangle bounds) {
		this.position = position;
		this.bounds = bounds;
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
	public void render() {
		// TODO Auto-generated method stub
		
	}

}
