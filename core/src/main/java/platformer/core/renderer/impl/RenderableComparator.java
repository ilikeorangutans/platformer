package platformer.core.renderer.impl;

import java.util.Comparator;

import platformer.core.renderer.Renderable;

public class RenderableComparator implements Comparator<Renderable> {

	@Override
	public int compare(Renderable o1, Renderable o2) {

		if (o1.getPosition().z != o2.getPosition().z) {
			return (int) (o1.getPosition().z - o2.getPosition().z);
		}

		return o1.getRendererInstructions().getTextureName()
				.compareTo(o2.getRendererInstructions().getTextureName());
	}

}
