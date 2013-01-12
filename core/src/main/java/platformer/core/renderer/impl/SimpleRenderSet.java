package platformer.core.renderer.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import platformer.core.model.GameObject;
import platformer.core.renderer.RenderSet;
import platformer.core.renderer.Renderable;

public class SimpleRenderSet implements RenderSet {

	private SortedSet<Renderable> renderables = new TreeSet<Renderable>(
			new RenderableComparator());

	@Override
	public Iterator<Renderable> iterator() {
		return renderables.iterator();

	}

	@Override
	public void add(Renderable renderable) {
		renderables.add(renderable);
	}

	@Override
	public void update(Collection<GameObject> list) {

	}

}
