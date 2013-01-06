package platformer.core.model.gameobject.impl;

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
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class SimulatableGameObject implements GameObject, Movable, Renderable,
		Simulatable {
	private Vector3 position;
	private boolean canBeRemoved;
	private Rectangle bounds;
	private Body body;
	private Fixture fixture;

	public SimulatableGameObject() {
		position = new Vector3(100, 200, 0);
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
	public void applyVelocity(Vector3 vector) {

	}

	@Override
	public boolean canBeRemoved() {
		return canBeRemoved;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getId() {
		return null;
	}

	@Override
	public void update() {
		Vector2 worldPosition = body.getPosition();
		position.x = worldPosition.x;
		position.y = worldPosition.y;
	}

	@Override
	public Body initialize(World world) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(position.x, position.y);

		body = world.createBody(bodyDef);

		body.setLinearDamping(1f);

		CircleShape circleShape = new CircleShape();
		circleShape.setRadius(bounds.width / 2);

		fixture = body.createFixture(circleShape, 70);
		fixture.setRestitution(1);

		return body;
	}

	@Override
	public String getTextureName() {
		return null;
	}

}
