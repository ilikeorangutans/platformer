package platformer.core.renderer.viewport;

import java.util.Collection;

import platformer.core.model.systems.Positionable;
import platformer.core.renderer.Renderable;
import platformer.core.renderer.Renderer;
import platformer.core.renderer.RendererFactory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class DefaultViewportRender implements ViewportRenderer {
	private final Graphics graphics;
	private final Camera camera;
	private final RendererFactory rendererFactory;
	private ShapeRenderer shapeRenderer;

	public DefaultViewportRender(RendererFactory rendererFactory, Graphics graphics, Camera camera) {
		this.rendererFactory = rendererFactory;
		this.graphics = graphics;
		this.camera = camera;
		shapeRenderer = new ShapeRenderer();
	}

	@Override
	public void render(Collection<Renderable> renderSet) {
		camera.update();

		Renderer lastRenderer = null;
		for (Renderable renderable : renderSet) {

			final Renderer renderer = rendererFactory.findRenderer(renderable.getClass());

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

	public void renderBackground(Positionable positionable) {

		float y = positionable.getPosition().y;

		float brightnessFactor = 1F - (y / 4096);
		if (brightnessFactor < 0.2F)
			brightnessFactor = 0.2F;

		Gdx.gl.glClearColor(0.23F * brightnessFactor, 0.43F * brightnessFactor, 0.61F * brightnessFactor, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		int x = 255;
		int y2 = 255;
		int width = 64;
		int height = 16;
		shapeRenderer.begin(ShapeType.FilledRectangle);
		shapeRenderer.setColor(1, 1, 1, 1);
		shapeRenderer.filledRect(x, y2, width, height);
		shapeRenderer.end();
		shapeRenderer.begin(ShapeType.FilledCircle);
		shapeRenderer.setColor(1, 1, 1, 1);
		shapeRenderer.filledCircle(x, y2 + 16, 16);
		shapeRenderer.filledCircle(x + 24, y2 + 24, 24);
		shapeRenderer.filledCircle(x + 64, y2 + 20, 20);
		shapeRenderer.end();
	}
}
