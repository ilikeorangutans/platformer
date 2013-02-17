package platformer.core.model.systems.impl.culling;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.IntMap;

/**
 * Implements buckets of objects of type T. Each bucket is identified by an x
 * and y value; internally this class organizes all buckets in columns and then
 * by rows.
 * 
 * @param <T>
 */
public class SpatialIndexMap<T> extends IntMap<IntMap<Array<T>>> {

	public Array<T> get(IntArray coordinates) {
		return get(coordinates.get(0), coordinates.get(1));
	}

	public Array<T> get(int x, int y) {
		IntMap<Array<T>> yCell = get(x);

		if (yCell == null) {
			yCell = new IntMap<Array<T>>();
			super.put(x, yCell);
		}

		Array<T> cell = yCell.get(y);

		if (cell == null) {
			cell = new Array<T>();
			yCell.put(y, cell);
		}

		return cell;
	}

	public void add(IntArray coordinates, T object) {
		add(coordinates.get(0), coordinates.get(1), object);
	}

	public void add(int x, int y, T object) {
		IntMap<Array<T>> yCell = get(x);
		Array<T> backingArray;

		if (yCell == null) {
			yCell = new IntMap<Array<T>>();
			put(x, yCell);
		}

		backingArray = yCell.get(y);
		if (backingArray == null) {
			backingArray = new Array<T>();
			yCell.put(y, backingArray);
		}

		if (backingArray.contains(object, true)) {
			return;
		}

		backingArray.add(object);
	}

	public void remove(IntArray coordinates) {
		Array<T> bucket = get(coordinates);
		bucket.clear();
	}

}
