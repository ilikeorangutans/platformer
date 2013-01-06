package platformer.core.renderer.impl.dummy;

import platformer.core.model.Renderable;
import platformer.core.model.gameobject.impl.DummyGameObject;
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
		if (DummyGameObject.class.isAssignableFrom(clazz)) {
			return renderer;
		} else {
			return circleRenderer;
		}
	}

}
