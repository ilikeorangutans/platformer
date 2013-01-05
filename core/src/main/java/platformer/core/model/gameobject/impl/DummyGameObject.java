package platformer.core.model.gameobject.impl;

import platformer.core.model.GameObject;
import platformer.core.model.Movable;
import platformer.core.model.Renderable;

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
		Gdx.app.debug("DummyGameObject", "We're getting disposed of.");
	}

	@Override
	public void update() {

		position.add(MathUtils.random(0.0F, 1.0F),
				MathUtils.random(0.0F, 1.0F), MathUtils.random(0.0F, 1.0F));

		Gdx.app.debug("DummyObject", "At " + position + " now.");

		counter++;

		if (counter > 100)
			canBeRemoved = true;
	}

	public void render() {
		// TODO Auto-generated method stub
	}
}
