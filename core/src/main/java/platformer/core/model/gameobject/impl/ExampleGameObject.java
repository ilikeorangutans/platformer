package platformer.core.model.gameobject.impl;

import platformer.core.model.GameObject;
import platformer.core.model.systems.Simulatable;
import platformer.core.renderer.Renderable;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;

public class ExampleGameObject implements GameObject, Simulatable, Renderable {
	private Vector3 position;
	private Rectangle bounds;
	private Body body;

	public ExampleGameObject(Vector3 position, Rectangle bounds, Body body) {
		this.position = position;
		this.bounds = bounds;
		this.body = body;
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
	public Body getPhysicsBody() {
		return body;
	}

	@Override
	public boolean canBeRemoved() {
		return false;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	@Override
	public String getId() {
		return "player";
	}

	@Override
	public String getTextureName() {
		return null;
	}

	@Override
	public void setPosition(Vector3 position) {
		this.position = position;		
	}

	@Override
	public void move(Vector3 vector) {
		this.getPhysicsBody().applyLinearImpulse(vector.x * 10000000, vector.y * 10000000, bounds.width / 2, bounds.height / 2);
	}

}
