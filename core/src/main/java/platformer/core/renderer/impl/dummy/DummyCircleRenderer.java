package platformer.core.renderer.impl.dummy;

import platformer.core.model.Renderable;
import platformer.core.renderer.Renderer;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class DummyCircleRenderer implements Renderer {

	private ShapeRenderer renderer;

	public DummyCircleRenderer() {
		renderer = new ShapeRenderer();
	}

	@Override
	public void render(Renderable renderable) {

		renderer.begin(ShapeType.FilledCircle);
		renderer.setColor(1, 0, 0, 1);
		renderer.filledCircle(renderable.getPosition().x,
				renderable.getPosition().y, renderable.getBounds().width / 2);
		renderer.end();

	}

}
