package platformer.core.renderer.impl.dummy;

import platformer.core.renderer.Renderable;
import platformer.core.renderer.Renderer;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class DummyRectanleRenderer implements Renderer {

	private ShapeRenderer renderer;
	private final Color color;

	public DummyRectanleRenderer(Color color) {
		this.color = color;
		renderer = new ShapeRenderer();
	}

	@Override
	public void render(Renderable renderable) {

		renderer.begin(ShapeType.FilledRectangle);
		renderer.setColor(color);
		renderer.filledRect(renderable.getPosition().x,
				renderable.getPosition().y, renderable.getBounds().width,
				renderable.getBounds().height);
		renderer.end();

	}

	@Override
	public void initialize(Camera camera) {
		renderer.setProjectionMatrix(camera.combined);
	}

	@Override
	public void finish() {
	}

}
