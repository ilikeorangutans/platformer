package platformer.core.model;

import java.util.Set;

import com.badlogic.gdx.math.Rectangle;

public interface SpatialHash<T> {
	//Adds new object to the spatial hash
	void addObject();
	
	//Get all objects contained in a single bucket 
	T getObjects(int cell);
	
	//Get all objects contained within the defined AABB range
	T getObjects(Rectangle aabb);
	
	//Get cell index for the object query
	int getCell(T object);
}
