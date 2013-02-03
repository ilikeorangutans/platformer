package platformer.core.model.systems.impl.culling;

import platformer.core.model.GameObject;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;

public class SpatialIndexMap<T> extends ObjectMap<Vector2, Array<T>> {

	public SpatialIndexMap(int numberOfBuckets) {
		super(numberOfBuckets);
	}

	public void put(Vector2 key, T object) {
		Array<T> backingArray = super.get(key);
		
		if (backingArray.contains(object, true)) {
			return;
		}
		
		backingArray.add(object);
	}

}
