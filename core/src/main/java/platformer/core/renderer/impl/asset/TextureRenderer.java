package platformer.core.renderer.impl.asset;

import platformer.core.model.GameObject;
import platformer.core.renderer.Renderable;
import platformer.core.renderer.Renderer;
import platformer.core.renderer.RendererInstructions;

import com.badlogic.gdx.Gdx;
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
		render(renderable, renderable.getPosition().x, renderable.getPosition().y);
	}
	
	public void render(Renderable renderable, float x, float y) {
		render(renderable, renderable.getPosition().x, renderable.getPosition().y, renderable.getBounds().width, renderable.getBounds().height);
	}
	
	public void render(Renderable renderable, float x, float y, float width, float height) {
		final RendererInstructions instructions = renderable.getRendererInstructions();

		final String textureName = instructions.getTextureName();
		final Texture texture = assetManager.get("assets/" + textureName + ".png", Texture.class);

		spriteBatch.draw(texture, x, y, width, height);		
	}

	@Override
	public void initialize(Camera camera, SpriteBatch batch) {
		if (initialized)
			return;

		initialized = true;
		spriteBatch = batch;
	}

	@Override
	public void finish() {
		initialized = false;
	}

}
