package platformer.core.model;

import java.util.Collection;

import platformer.core.model.condition.Condition;
import platformer.core.model.systems.impl.physics.PhysicsSystem;

import com.badlogic.gdx.math.Vector2;

public interface Level {

	/**
	 * Returns a collection of game objects that this level provides.
	 * 
	 * @return
	 */
	Collection<GameObject> getGameObjects();

	/**
	 * Returns a {@link Vector2} describing the gravity to be used in this
	 * level.
	 * 
	 * @return
	 */
	Vector2 getGravity();

	void initialize(PhysicsSystem physicsSystem);

	Condition getWinningCondition();

	Condition getLosingCondition();

}
