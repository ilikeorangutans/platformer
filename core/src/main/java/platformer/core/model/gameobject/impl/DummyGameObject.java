package platformer.core.model.gameobject.impl;

import platformer.core.model.GameObject;
import platformer.core.model.Movable;
import platformer.core.renderer.Renderable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class DummyGameObject implements GameObject, Movable, Renderable {

	private Vector3 position;
	private Rectangle bounds;
	private int counter;
	private boolean canBeRemoved;

	public DummyGameObject() {
		position = new Vector3(10, 10, 10);
		bounds = new Rectangle(10, 10, 10, 10);
	}

	@Override
	public boolean canBeRemoved() {
		return canBeRemoved;
	}

	@Override
	public void dispose() {
		Gdx.app.debug("DummyGameObject", "We're getting disposed of.");
	}

	@Override
	public Rectangle getBounds() {
		return bounds;
	}

	@Override
	public Vector3 getPosition() {
		return position;
	}

	@Override
	public void update() {

		position.add(MathUtils.random(0.0F, 1.0F),
				MathUtils.random(-1.0F, 1.0F), 0);

		Gdx.app.debug("DummyObject", "At " + position + " now.");

		counter++;

		if (counter > 10000)
			canBeRemoved = true;
	}

	@Override
	public void applyVelocity(Vector3 vector) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTextureName() {
		return null;
	}

}
