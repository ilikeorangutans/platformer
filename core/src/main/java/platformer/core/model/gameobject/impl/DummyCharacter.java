package platformer.core.model.gameobject.impl;

import platformer.core.model.Controllable;
import platformer.core.model.GameObject;
import platformer.core.model.Movable;
import platformer.core.model.Simulatable;
import platformer.core.renderer.Renderable;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class DummyCharacter implements GameObject, Movable, Controllable,
		Renderable, Simulatable {

	private Vector3 position;
	private boolean canBeRemoved;
	private Rectangle bounds;
	private Body body;
	private Fixture fixture;

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
		Vector2 worldPosition = body.getPosition();
		position.x = worldPosition.x;
		position.y = worldPosition.y;
	}

	@Override
	public void applyVelocity(Vector3 vector) {		
		body.applyLinearImpulse(vector.x * 10000, vector.y * 10000, bounds.width / 2, bounds.height / 2);
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
	
	@Override
	public Body initialize(World world) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(position.x, position.y);

		body = world.createBody(bodyDef);
		body.setFixedRotation(true);
		body.setLinearDamping(0.5f);

		PolygonShape squareShape = new PolygonShape();
		squareShape.setAsBox(bounds.width / 2, bounds.height / 2);

		fixture = body.createFixture(squareShape, 30);
		//fixture.setFriction(5f);
		fixture.setRestitution(0);

		return body;
	}

}
