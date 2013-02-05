package platformer.core.model.systems.impl.culling;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntMap;

public class SpatialIndexMap<T> extends IntMap<Array<T>> {

	public Array<T> get(int key) {
		Array<T> cell = super.get(key);

		if (cell == null) {
			cell = new Array<T>();
			super.put(key, cell);
		}

		return cell;
	}
	
	public void add(int key, T object) {
		Array<T> backingArray = get(key);
		
		if (backingArray.contains(object, true)) {
			return;
		}

		backingArray.add(object);
	}

}
