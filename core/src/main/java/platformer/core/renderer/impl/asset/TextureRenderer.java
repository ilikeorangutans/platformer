package platformer.core.renderer.impl.asset;

import platformer.core.renderer.Renderable;
import platformer.core.renderer.Renderer;
import platformer.core.renderer.RendererInstructions;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextureRenderer implements Renderer {

	private final AssetManager assetManager;
	private SpriteBatch spriteBatch;
	private boolean initialized = false;

	public TextureRenderer(AssetManager assetManager) {
		this.assetManager = assetManager;
		spriteBatch = new SpriteBatch();
	}

	@Override
	public void render(Renderable renderable) {
		final RendererInstructions instructions = renderable
				.getRendererInstructions();

		final String textureName = instructions.getTextureName();
		final Texture texture = assetManager.get("assets/" + textureName
				+ ".png", Texture.class);

		spriteBatch.draw(texture, renderable.getPosition().x,
				renderable.getPosition().y);
	}

	@Override
	public void initialize(Camera camera) {
		if (initialized)
			return;

		initialized = true;

		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();
	}

	@Override
	public void finish() {
		spriteBatch.end();
		initialized = false;
	}

}
