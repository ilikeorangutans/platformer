package platformer.core.renderer.impl.background;

import platformer.core.renderer.Renderable;
import platformer.core.renderer.Renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector3;

public class BackgroundCloudRenderer implements Renderer {

	private final ShapeRenderer shapeRenderer = new ShapeRenderer();
	private Vector3 cameraPosition;

	@Override
	public void initialize(Camera camera) {
		cameraPosition = camera.position;
		shapeRenderer.setProjectionMatrix(camera.combined);
	}

	@Override
	public void finish() {
	}

	@Override
	public void render(Renderable renderable) {

		final float z = renderable.getPosition().z;
		final float cameraDeltaX = (cameraPosition.x - renderable.getPosition().x) / (z * 10);
		final float cameraDeltaY = (cameraPosition.y - renderable.getPosition().y) / (z * 5);
		final float x = renderable.getPosition().x - cameraDeltaX;
		final float y = renderable.getPosition().y - cameraDeltaY;
		final float scale = 2 / z;
		final int width = (int) (64 * scale);
		final int height = (int) (16 * scale);
		final float small = 16 * scale;
		final float medium = 20 * scale;
		final float large = 24 * scale;

		shapeRenderer.begin(ShapeType.FilledRectangle);
		shapeRenderer.setColor(1, 1, 1, 1);
		shapeRenderer.filledRect(x, y, width, height);
		shapeRenderer.end();
		shapeRenderer.begin(ShapeType.FilledCircle);
		shapeRenderer.setColor(1, 1, 1, 1);
		shapeRenderer.filledCircle(x, y + small, small);
		shapeRenderer.filledCircle(x + large, y + large, large);
		shapeRenderer.filledCircle(x + width, y + medium, medium);
		shapeRenderer.end();

	}

}
