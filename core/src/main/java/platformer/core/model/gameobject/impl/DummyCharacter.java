package platformer.core.model.gameobject.impl;

import platformer.core.model.Controllable;
import platformer.core.model.GameObject;
import platformer.core.model.Movable;
import platformer.core.renderer.Renderable;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class DummyCharacter implements GameObject, Movable, Controllable,
		Renderable {

	private Vector3 position;
	private boolean canBeRemoved;
	private Rectangle bounds;

	public DummyCharacter() {
		position = new Vector3(100, 100, 0);
		bounds = new Rectangle(10, 10, 10, 10);
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
		return canBeRemoved;
	}

	@Override
	public void dispose() {

	}

	@Override
	public void update() {

	}

	@Override
	public void applyVelocity(Vector3 vector) {
		position.add(vector);
	}

	@Override
	public String getId() {
		return "player";
	}

	@Override
	public String getTextureName() {
		// TODO Auto-generated method stub
		return null;
	}

}
