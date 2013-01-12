package platformer.core.renderer.impl;

import org.junit.Test;

import com.badlogic.gdx.math.Vector3;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import platformer.core.renderer.Renderable;

public class RenderableComparatorTest {

	@Test
	public void testZorderSorting() {

		RenderableComparator comparator = new RenderableComparator();

		Renderable o1 = mock(Renderable.class);
		when(o1.getPosition()).thenReturn(new Vector3(0, 0, 0));
		Renderable o2 = mock(Renderable.class);
		when(o2.getPosition()).thenReturn(new Vector3(0, 0, 1));

		assertThat(comparator.compare(o1, o2), is(-1));
	}

}
