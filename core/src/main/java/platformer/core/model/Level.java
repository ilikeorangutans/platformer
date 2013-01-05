package platformer.core.model;

import java.util.Collection;

public interface Level {

	/**
	 * Returns a collection of game objects that this level provides.
	 * 
	 * @return
	 */
	Collection<GameObject> getGameObjects();

}
