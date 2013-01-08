package platformer.core.model.systems.impl.physics;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import platformer.core.model.GameObject;
import platformer.core.model.systems.GenericSystem;
import platformer.core.model.systems.PhysicsBody;
import platformer.core.model.systems.Simulatable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.QueryCallback;
import com.badlogic.gdx.physics.box2d.World;

public class PhysicsSystem implements GenericSystem {
	World world;
	private boolean isCurrentObjectGrounded;
	private int fixtureCount;

	public PhysicsSystem(Vector2 gravity) {
		world = new World(gravity, true);
	}

	public Body createBody(String bodyName, Vector3 position, Rectangle bounds) {
		Body body = null;

		Constructor construct;
		try {
			construct = Class.forName(bodyName).getConstructor();
			Object newInstance = construct.newInstance(null);
			body = ((PhysicsBody) newInstance).create(world, position, bounds);
		} catch (NoSuchMethodException e) {
			Gdx.app.log("PhysicsBodyFactory", "No method found", e);
		} catch (SecurityException e) {
			Gdx.app.log("PhysicsBodyFactory", "Security exception", e);
		} catch (ClassNotFoundException e) {
			Gdx.app.log("PhysicsBodyFactory", "Class not found", e);
		} catch (InstantiationException e) {
			Gdx.app.log("PhysicsBodyFactory", "Error instantiating", e);
		} catch (IllegalAccessException e) {
			Gdx.app.log("PhysicsBodyFactory", "IllegalAccess", e);
		} catch (IllegalArgumentException e) {
			Gdx.app.log("PhysicsBodyFactory", "IllegalArgument", e);
		} catch (InvocationTargetException e) {
			Gdx.app.log("PhysicsBodyFactory", "InvocationgTarget", e);
		}
		
		return body;
	}
	
	public World getWorld() {
		return world;
	}

	@Override
	public void update(Collection<GameObject> list) {
		for (GameObject gameObject : list) {
			Simulatable simulatable = (Simulatable) gameObject;
			Body curBody = simulatable.getPhysicsBody();
			
			//Update position
			Vector2 position = curBody.getPosition();
			simulatable.setPosition(new Vector3(position.x, position.y, 0));
			
			if (curBody.getType() != BodyType.StaticBody) {
				simulatable.setIsGrounded(checkIfIsGrounded(simulatable));
			}
		}
		
		world.step(Gdx.graphics.getDeltaTime(), 8, 3);
	}

	private boolean checkIfIsGrounded(Simulatable simulatable) {
		isCurrentObjectGrounded = false;
		fixtureCount = 0;
		
		Vector3 pos = simulatable.getPosition();
		Rectangle bounds = simulatable.getBounds();
		
		//Don't forget, x/y are center to the object
		float leftBottomX = pos.x;
		float leftBottomY = pos.y - (bounds.height / 2) - 2; //Test 2 pixels under
		float topRightX = pos.x;
		float topRightY = pos.y - (bounds.height / 2);
		
		world.QueryAABB(new QueryCallback() {			
			@Override
			public boolean reportFixture(Fixture fixture) {
				fixtureCount++;
				if(fixtureCount == 2) {
					isCurrentObjectGrounded = true;
				}
				return true;
			}			
		}, leftBottomX, leftBottomY, topRightX, topRightY);
		
		return isCurrentObjectGrounded;
	}

}
