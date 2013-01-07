package platformer.core.renderer.impl.dummy;

import platformer.core.renderer.Renderable;
import platformer.core.renderer.Renderer;
import platformer.core.renderer.RendererFactory;

import com.badlogic.gdx.graphics.Color;

public class DummyRendererFactory implements RendererFactory {

	private Renderer renderer;
	private Renderer circleRenderer;

	public DummyRendererFactory() {
		Color color = new Color(1, 1, 1, 1);
		renderer = new DummyRectanleRenderer(color);
		circleRenderer = new DummyCircleRenderer();
	}

	@Override
	public Renderer findRenderer(Class<? extends Renderable> clazz) {
		return circleRenderer;
	}

}
