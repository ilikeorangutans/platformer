package platformer.core.model.systems.impl.physics.bodies;

import platformer.core.model.systems.PhysicsBody;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class RegularPlayer implements PhysicsBody {
	public Body create(World world, Vector3 position, Rectangle bounds) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(position.x, position.y);

		Body body = world.createBody(bodyDef);
		body.setFixedRotation(true);
		body.setBullet(true);

		PolygonShape rectShape = new PolygonShape();
		rectShape.setAsBox(bounds.width / 4, bounds.height / 2, new Vector2(0, 0), 0);

		Fixture fixture = body.createFixture(rectShape, 1);
		fixture.setRestitution(0);
		fixture.setFriction(0.1f);
		
		return body;
	}
	
}
