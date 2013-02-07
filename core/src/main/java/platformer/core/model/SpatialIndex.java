package platformer.core.model;

import java.util.Set;

import platformer.core.model.systems.Positionable;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public interface SpatialIndex<T extends Positionable> {
	//Adds new object to the spatial hash
	void addObject(T object);
		
	//Get all objects contained within the defined AABB range
	Array<T> getObjects(Rectangle aabb);

	//
	void updateObjects(Rectangle aabb);
}
