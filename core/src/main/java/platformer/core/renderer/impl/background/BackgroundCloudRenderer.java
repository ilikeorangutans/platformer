package platformer.core.renderer.impl.background;

import platformer.core.renderer.Renderable;
import platformer.core.renderer.impl.asset.TextureRenderer;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class BackgroundCloudRenderer extends TextureRenderer{

	public BackgroundCloudRenderer(AssetManager assetManager) {
		super(assetManager);
	}

	private Vector3 cameraPosition;

	@Override
	public void initialize(Camera camera, SpriteBatch batch) {
		super.initialize(camera, batch);
		cameraPosition = camera.position;
	}

	@Override
	public void render(Renderable renderable) {

		final float z = renderable.getPosition().z;
		final float cameraDeltaX = (cameraPosition.x - renderable.getPosition().x) / (z * 5);
		final float cameraDeltaY = (cameraPosition.y - renderable.getPosition().y) / (z * 5);
		final float x = renderable.getPosition().x - cameraDeltaX;
		final float y = renderable.getPosition().y - cameraDeltaY;
		final float scale = 2 / z;
		final int width = (int) (64 * scale);
		final int height = (int) (64 * scale);
		final float small = 0.5f;
		final float medium = 0.75f;

		render(renderable, x, y, width, height);
		render(renderable, x - 15, y, width * small, height * small);
		render(renderable, x + 15, y, width * medium, height * medium);
		render(renderable, x + 30, y, width * small, height * small);
	}

}
