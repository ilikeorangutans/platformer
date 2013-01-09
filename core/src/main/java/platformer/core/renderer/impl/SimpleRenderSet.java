package platformer.core.renderer.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import platformer.core.renderer.RenderSet;
import platformer.core.renderer.Renderable;

public class SimpleRenderSet implements RenderSet {

	private List<Renderable> renderables = new ArrayList<Renderable>();

	@Override
	public Iterator<Renderable> iterator() {
		return renderables.iterator();
	}

	@Override
	public void add(Renderable renderable) {
		renderables.add(renderable);
	}

}
