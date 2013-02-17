package platformer.core.model;

import platformer.core.model.systems.Positionable;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public interface SpatialIndex<T extends Positionable> {
	/**
	 * Adds new object to the spatial hash
	 * 
	 * @param object
	 */
	void addObject(T object);

	/**
	 * Get all objects contained within the defined AABB range
	 * 
	 * @param aabb
	 * @return
	 */
	Array<T> getObjects(Rectangle aabb);

	void updateObjects(Rectangle aabb);
}
