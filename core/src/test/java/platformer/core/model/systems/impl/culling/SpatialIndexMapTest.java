package platformer.core.model.systems.impl.culling;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import platformer.core.model.systems.Positionable;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntArray;

public class SpatialIndexMapTest {

	SpatialIndexMap<Positionable> map = new SpatialIndexMap<Positionable>();

	@Test
	public void testAdd() {

		Positionable object = new TestPositionable(1, 1);
		map.add(1, 1, object);

		assertThat(map.size, is(1));

		Array<Positionable> bucket = map.get(1, 1);
		assertThat(bucket, notNullValue());
		assertThat(bucket.size, is(1));
		assertThat(bucket, hasItems(object));

	}

	@Test
	public void testGetMissing() {

		Array<Positionable> array = map.get(1, 1);
		assertThat(array, notNullValue());

	}

	@Test
	public void testRemove() {
		Positionable object = new TestPositionable(1, 1);
		map.add(1, 1, object);

		Array<Positionable> bucket = map.get(1, 1);
		assertThat(bucket, notNullValue());
		assertThat(bucket.size, is(1));

		map.remove(new IntArray(new int[] { 1, 1 }));

		assertThat(bucket, notNullValue());
		assertThat(bucket.size, is(0));

	}
}
