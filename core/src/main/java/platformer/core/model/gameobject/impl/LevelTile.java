package platformer.core.model.gameobject.impl;

import platformer.core.model.GameObject;
import platformer.core.model.Positionable;
import platformer.core.model.Simulatable;
import platformer.core.renderer.Renderable;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class LevelTile implements GameObject, Positionable, Renderable,
		Simulatable {

	private final Vector3 position;
	private final Rectangle bounds;
	private ShapeRenderer renderer;
	private Body body;
	private Fixture fixture;

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
	public String getId() {
		return null;
	}

	@Override
	public String getTextureName() {
		return "grass";
	}

	public Body initialize(World world) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.StaticBody;
		bodyDef.position.set(position.x, position.y);

		body = world.createBody(bodyDef);

		CircleShape tileShape = new CircleShape();
		tileShape.setRadius(bounds.width / 2);
		
		fixture = body.createFixture(tileShape, 70);
		fixture.setFriction(5f);
		fixture.setRestitution(1f);

		return body;
	}
}
