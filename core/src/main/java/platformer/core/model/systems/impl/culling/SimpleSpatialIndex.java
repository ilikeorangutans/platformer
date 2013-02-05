package platformer.core.model.systems.impl.culling;

import platformer.core.model.GameObject;
import platformer.core.model.SpatialIndex;
import platformer.core.model.systems.Positionable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntArray;

public class SimpleSpatialIndex<T extends Positionable> implements SpatialIndex<T> {
	private int cellSize;
	private SpatialIndexMap<T> cellMap;
	private float conversionFactor;
	private int width;

	/**
	 * The constructor requires both the cellSize (usually enough to fit a
	 * regular object bounding box) and width required for projecting a spatial
	 * index into 1D. Usually the width is expected to be provided by the Level
	 * object.
	 * 
	 * @param cellSize
	 * @param initialWidth
	 */
	public SimpleSpatialIndex(int cellSize, int width) {
		this.cellSize = cellSize;
		this.width = width / cellSize;
		this.conversionFactor = 1f / cellSize;
		cellMap = new SpatialIndexMap<T>();
	}

	/**
	 * The function takes a bounded object as a parameter and computes what grid
	 * cells it hashes to.
	 * 
	 * @param obj
	 * @return void
	 */
	@Override
	public void addObject(T object) {
		if (object instanceof Positionable) {
			Positionable obj = (Positionable) object;
			Vector3 objPos = obj.getPosition();
			Rectangle objBounds = obj.getBounds();
			Rectangle boundingBox = new Rectangle(objPos.x, objPos.y, objBounds.width, objBounds.height);

			IntArray affectedCells = getAffectedCells(boundingBox);
			
			if("player".equals(((GameObject) obj).getId())){
				Gdx.app.log("player", affectedCells.toString());
			}

			for (int i = 0; i < affectedCells.size; i++) {
				cellMap.add(affectedCells.get(i), object);
			}
		} else {
			Gdx.app.error("SimpleSpatialIndex", "Object not added; GameObject is expected to be instance of Positionable");
		}
	}

	private int hashPoint(Vector2 point) {
		int gridCell;

		gridCell = (int) (point.x * conversionFactor + point.y * conversionFactor * width);

		return gridCell;
	}

	/**
	 * Returns an array of cells affected by the AABB query
	 * 
	 * Make sure to dispose of the result once done
	 * 
	 * @param aabb
	 * @return Array<Vector2>
	 */
	private IntArray getAffectedCells(Rectangle aabb) {
		IntArray affectedCells = new IntArray();

		Vector2 frustrumMinPoint = new Vector2(aabb.x, aabb.y);
		Vector2 frustrumMaxPoint = new Vector2(aabb.x + aabb.width, aabb.y + aabb.height);

		int minX = (int) (frustrumMinPoint.x * conversionFactor);
		int minY = (int) (frustrumMinPoint.y * conversionFactor);

		int maxX = (int) (frustrumMaxPoint.x * conversionFactor);
		int maxY = (int) (frustrumMaxPoint.y * conversionFactor);

		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) {
				affectedCells.add(i * width + j);
			}
		}

		return affectedCells;
	}

	@Override
	public Array<T> getObjects(int cell) {
		return cellMap.get(cell);
	}

	@Override
	public Array<T> getObjects(Rectangle aabb) {
		IntArray affectedCells = getAffectedCells(aabb);
		Array<T> objects = new Array<T>();

		for (int i = 0; i < affectedCells.size; i++) {
			Array<T> currentCell = cellMap.get(affectedCells.get(i));

			for (T gameObject : currentCell) {
				if (!objects.contains(gameObject, true)) {
					objects.add(gameObject);
				}
			}
		}

		return objects;
	}

	public void updateObjects(Rectangle aabb) {
		IntArray affectedCells = getAffectedCells(aabb);
		Array<T> objects = new Array<T>(getObjects(aabb));

		for (int i = 0; i < affectedCells.size; i++) {
			cellMap.remove(affectedCells.get(i));
		}

		for (T gameObject : objects) {
			addObject(gameObject);
		}
	}
}
