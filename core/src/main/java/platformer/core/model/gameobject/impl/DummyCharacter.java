package platformer.core.model.gameobject.impl;

import platformer.core.model.Controllable;
import platformer.core.model.GameObject;
import platformer.core.model.Movable;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class DummyCharacter implements GameObject, Movable, Controllable {

	private Vector3 position;
	private boolean canBeRemoved;

	public DummyCharacter() {
		position = new Vector3(10, 10, 0);
	}

	@Override
	public Vector3 getPosition() {
		return position;
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

	@Override
	public boolean canBeRemoved() {
		return canBeRemoved;
	}

	@Override
	public void dispose() {

	}

	@Override
	public void update() {

	}

}
