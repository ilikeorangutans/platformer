package platformer.core.model.systems.impl.culling;

import java.util.Hashtable;

import platformer.core.model.GameObject;
import platformer.core.model.SpatialIndex;
import platformer.core.model.systems.Positionable;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntMap;
import com.badlogic.gdx.utils.ObjectMap;

public class SimpleSpatialIndex<T extends Positionable> implements SpatialIndex<T> {
	private int cellSize;
	private SpatialIndexMap<T> cellMap;
	private int conversionFactor;
	private int min;
	private int max;
	private int width;
	private int numberOfBuckets;

	public SimpleSpatialIndex(int cellSize, int min, int max) {
		this.min = min;
		this.max = max;
		this.width = max - min;
		this.cellSize = cellSize;
		this.conversionFactor = 1 / cellSize;
		this.numberOfBuckets = (int) Math.pow(width, 2);
		cellMap = new SpatialIndexMap<T>(numberOfBuckets);
	}

	/**
	 * The function takes a bounded object as a parameter and computes what grid
	 * cells it hashes to. Notice that the function short-circuit evaluates
	 * based on the fact that: if min and max hash to the same cell, no further
	 * evaluation is required (which will usually be the case).
	 * 
	 * @param obj
	 * @return void
	 */
	@Override
	public void addObject(T object) {
		Positionable posObj;
		int targetBucket;

		if (object instanceof Positionable) {
			Positionable obj = (Positionable) object;
			Vector3 objPos = obj.getPosition();
			Rectangle objBounds = obj.getBounds();
			Rectangle boundingBox = new Rectangle(objPos.x, objPos.y, objBounds.width, objBounds.height);
			Array<Vector2> affectedCells = getAffectedCells(boundingBox);
			
			for (Vector2 cellIdx: affectedCells) {
				cellMap.put(cellIdx, object);
			}
		} else {
			Gdx.app.error("SimpleSpatialIndex", "Object not added; GameObject is expected to be instance of Positionable");
		}
	}

	private Vector2 hashPoint(Vector3 point) {
		Vector2 gridCell = new Vector2();

		gridCell.x = point.x * conversionFactor;
		gridCell.y = point.y * conversionFactor;

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
	private Array<Vector2> getAffectedCells(Rectangle aabb) {
		Array<Vector2> affectedCells = new Array<Vector2>();
		Vector2 cellAA = hashPoint(new Vector3(aabb.x, aabb.y, 0));
		Vector2 cellBB = hashPoint(new Vector3(aabb.x + aabb.width, aabb.y + aabb.height, 0));

		if (cellAA.equals(cellBB)) {
			// Object occupies grid cellA
			affectedCells.add(cellAA);
		} else if (cellAA.x == cellBB.x || cellAA.y == cellBB.y) {
			// Object occupies cellA and B
			affectedCells.add(cellAA);
			affectedCells.add(cellBB);
		} else {
			// Object present in all four cells
			Vector2 cellAB = hashPoint(new Vector3(aabb.x, aabb.y + aabb.height, 0));
			Vector2 cellBA = hashPoint(new Vector3(aabb.x + aabb.width, aabb.y, 0));

			affectedCells.add(cellAA);
			affectedCells.add(cellAB);
			affectedCells.add(cellBB);
			affectedCells.add(cellBA);
		}
		
		return affectedCells;
	}

	@Override
	public Array<T> getObjects(Vector2 cell) {
		return cellMap.get(cell); 
	}

	@Override
	public Array<T> getObjects(Rectangle aabb) {
		Array<Vector2> affectedCells = getAffectedCells(aabb);
		Array<T> objects = new Array<T>();		
		
		for (Vector2 cellIdx : affectedCells) {
			Array<T> currentCell = cellMap.get(cellIdx);
			
			for (T gameObject : currentCell) {
				if( !objects.contains(gameObject, true) ) {
					objects.add(gameObject);
				}
			}
		}
		
		return objects;
	}
	
	public void updateObjects(Rectangle aabb) {
		Array<Vector2> affectedCells = getAffectedCells(aabb);
		Array<T> objects = new Array<T>(getObjects(aabb));
		
		for (Vector2 cellIdx : affectedCells) {
			cellMap.put(cellIdx, new Array<T>());
		}
		
		for (T gameObject : objects) {
			addObject(gameObject);
		}		
	}
}
