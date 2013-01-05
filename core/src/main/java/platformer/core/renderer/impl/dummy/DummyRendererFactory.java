package platformer.core.renderer.impl.dummy;

import platformer.core.model.Renderable;
import platformer.core.renderer.Renderer;
import platformer.core.renderer.RendererFactory;

import com.badlogic.gdx.graphics.Color;

public class DummyRendererFactory implements RendererFactory {

	private Renderer renderer;

	public DummyRendererFactory() {
		Color color = new Color(1, 1, 1, 1);
		renderer = new DummyRectanleRenderer(color);
	}

	@Override
	public Renderer findRenderer(Class<Renderable> clazz) {
		return renderer;
	}

}
