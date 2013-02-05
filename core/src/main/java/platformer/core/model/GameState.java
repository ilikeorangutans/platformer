package platformer.core.model;

import java.util.Collection;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import platformer.core.model.systems.Simulatable;
import platformer.core.renderer.Renderable;

/**
 * Acts as a registry and directory for all {@link GameObject}s.
 * 
 * @author Jakob Külzer
 * 
 */
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
	 * Finds a {@link GameObject} based on its id. If no such game object
	 * exists, null is returned.
	 * 
	 * @param id
	 * @return
	 */
	GameObject findGameObjectById(String id);

	/**
	 * Returns all game objects that are also renderable.
	 * 
	 * @return
	 */

	void initialize(Level level);

	/**
	 * Updates the gamestate with input.
	 * @param rectangle 
	 * 
	 * @param inputState
	 */
	void update(Rectangle rectangle);

	Collection<GameObject> getActiveObjects();

	Array<Simulatable> getSimulatableObjects(Rectangle aabb);
	
	Array<Renderable> getRenderableObjects(Rectangle aabb);
}
