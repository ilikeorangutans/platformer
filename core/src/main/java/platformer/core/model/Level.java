package platformer.core.model;

import java.util.Collection;

import platformer.core.model.systems.impl.physics.PhysicsSystem;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public interface Level {

	/**
	 * Returns a collection of game objects that this level provides.
	 * 
	 * @return
	 */
	Collection<GameObject> getGameObjects();
	
	Vector2 getGravity();

	void initialize(PhysicsSystem physicsSystem);

}
