package platformer.core.model;

import java.util.Collection;

import platformer.core.renderer.Renderable;

import com.badlogic.gdx.physics.box2d.World;

public interface GameState extends Iterable<GameObject> {

	/**
	 * 
	 * @param gameObject
	 */
	void addGameObject(GameObject gameObject);

	/**
	 * Performs cleanup, like removing objects that are schedule for removal.
	 * Should be called after each iteration of the game loop.
	 */
	void cleanUp();

	/**
	 * Returns all game objects that are also renderable.
	 * 
	 * @return
	 */
	Collection<Renderable> getRenderableObjects();

	/**
	 * Updates the gamestate with input.
	 * 
	 * @param inputState
	 */
	void update();

	void initialize(Level level);

	/**
	 * Finds a {@link GameObject} based on its id. If no such game object
	 * exists, null is returned.
	 * 
	 * @param id
	 * @return
	 */
	GameObject findGameObjectById(String id);
	
	/**
	 * Returns a physics {@link World} based. 
	 * 
	 * @return World
	 */
	World getWorld();

}
