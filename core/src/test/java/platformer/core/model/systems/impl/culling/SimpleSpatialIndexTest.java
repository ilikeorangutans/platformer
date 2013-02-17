package platformer.core.model.systems.impl.culling;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import platformer.core.model.systems.Positionable;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntArray;

public class SimpleSpatialIndexTest {

	SimpleSpatialIndex<Positionable> index = new SimpleSpatialIndex<Positionable>(100);

	@Test
	public void testGetObjects() {

		Positionable object = new TestPositionable(10, 10);
		index.addObject(object);

		Array<Positionable> objects = index.getObjects(new Rectangle(0, 0, 1, 1));

		assertThat(objects, notNullValue());
		assertThat(objects.size, is(1));
	}

	@Test
	public void testGetObjectsWithReallyWideObject() {

		// Create an object that spans both buckets
		Positionable object = new TestPositionable(10, 10, 10, 10, 200, 10);
		index.addObject(object);

		Array<Positionable> objects;

		objects = index.getObjects(new Rectangle(0, 0, 99, 9));
		assertThat(objects.size, is(1));

		objects = index.getObjects(new Rectangle(100, 0, 100, 100));
		assertThat(objects.size, is(1));

	}

	@Test
	public void testGetObjectsWithEvenWiderObject() {

		// Create an object that spans both buckets
		Positionable object = new TestPositionable(10, 10, 10, 10, 300, 10);
		index.addObject(object);

		Array<Positionable> objects;

		objects = index.getObjects(new Rectangle(0, 0, 99, 9));
		assertThat(objects.size, is(1));

		objects = index.getObjects(new Rectangle(100, 0, 100, 100));
		assertThat(objects.size, is(1));

		objects = index.getObjects(new Rectangle(200, 0, 100, 100));
		assertThat(objects.size, is(1));

	}

	@Test
	public void testGetBucketId() {
		Vector2 bucketId;

		bucketId = index.getBucketId(new Vector2(0, 0));
		assertThat(bucketId.x, is(0F));
		assertThat(bucketId.y, is(0F));

		bucketId = index.getBucketId(new Vector2(99, 99));
		assertThat(bucketId.x, is(0F));
		assertThat(bucketId.y, is(0F));

		bucketId = index.getBucketId(new Vector2(100, 100));
		assertThat(bucketId.x, is(1F));
		assertThat(bucketId.y, is(1F));

		bucketId = index.getBucketId(new Vector2(50, 150));
		assertThat(bucketId.x, is(0F));
		assertThat(bucketId.y, is(1F));

		bucketId = index.getBucketId(new Vector2(-10, -10));
		assertThat(bucketId.x, is(0F));
		assertThat(bucketId.y, is(0F));

	}

	@Test
	public void testGetAffectedCells() {
		Array<IntArray> cells;

		cells = index.getAffectedCells(new Rectangle(0, 0, 99, 99));
		assertThat(cells.size, is(1));

		cells = index.getAffectedCells(new Rectangle(-1, -1, 99, 99));
		assertThat(cells.size, is(1));

		cells = index.getAffectedCells(new Rectangle(0, 0, 100, 100));
		assertThat(cells.size, is(4));

		cells = index.getAffectedCells(new Rectangle(0, 0, 200, 200));
		assertThat(cells.size, is(9));

		cells = index.getAffectedCells(new Rectangle(0, 0, 200, 99));
		assertThat(cells.size, is(3));

	}
}
