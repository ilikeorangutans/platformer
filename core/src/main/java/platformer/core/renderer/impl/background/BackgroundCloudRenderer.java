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
		final float scale = 1.5f / z;
		final int width = (int) (renderable.getBounds().width * scale);
		final int height = (int) (renderable.getBounds().height * scale);

		render(renderable, x, y, width, height);
	}

}
