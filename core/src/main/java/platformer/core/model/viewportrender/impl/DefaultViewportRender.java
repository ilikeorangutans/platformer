package platformer.core.model.viewportrender.impl;

import java.util.Collection;

import platformer.core.model.ViewportRender;
import platformer.core.renderer.Renderable;
import platformer.core.renderer.Renderer;
import platformer.core.renderer.RendererFactory;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Camera;

public class DefaultViewportRender implements ViewportRender {
	private final Graphics graphics;
	private final Camera camera;
	private final RendererFactory rendererFactory;

	public DefaultViewportRender(RendererFactory rendererFactory,
			Graphics graphics, Camera camera) {
		this.rendererFactory = rendererFactory;
		this.graphics = graphics;
		this.camera = camera;
	}

	@Override
	public void render(Collection<Renderable> renderableObjects) {
		camera.update();

		Renderer lastRenderer = null;
		for (Renderable renderable : renderableObjects) {

			final Renderer renderer = rendererFactory.findRenderer(renderable
					.getClass());

			renderer.initialize(camera);

			renderer.render(renderable);

			if (lastRenderer != null && lastRenderer != renderer) {
				renderer.finish();
			}

			lastRenderer = renderer;
		}

		if (lastRenderer != null)
			lastRenderer.finish();

	}
}
