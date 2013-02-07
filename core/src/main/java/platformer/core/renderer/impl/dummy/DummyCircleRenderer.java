package platformer.core.renderer.impl.dummy;

import platformer.core.renderer.Renderable;
import platformer.core.renderer.Renderer;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class DummyCircleRenderer implements Renderer {

	private ShapeRenderer renderer;

	public DummyCircleRenderer() {
		renderer = new ShapeRenderer();
	}

	@Override
	public void render(Renderable renderable) {

		renderer.begin(ShapeType.Filled);
		renderer.setColor(1, 0, 0, 1);
		renderer.circle(renderable.getPosition().x, renderable.getPosition().y,
				renderable.getBounds().width / 2);

		renderer.end();

	}

	@Override
	public void initialize(Camera camera, SpriteBatch batch) {
		renderer.setProjectionMatrix(camera.combined);
	}

	@Override
	public void finish() {
	}

}
