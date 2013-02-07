package platformer.core.renderer.impl.asset;

import platformer.core.model.GameObject;
import platformer.core.renderer.Renderable;
import platformer.core.renderer.Renderer;
import platformer.core.renderer.RendererInstructions;
import platformer.core.renderer.impl.AbstractRenderInstructions.TextureType;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

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
		final TextureType textureType = instructions.getTextureType();
		
		if (TextureType.SINGLE == textureType) {
			final Texture texture = assetManager.get("assets/" + textureName + ".png", Texture.class);
			spriteBatch.draw(texture, x, y, width, height);		
		} else {
			final int frame = instructions.getFrame();
			final TextureAtlas atlas = assetManager.get("assets/sprites/packed/" + textureName + ".txt", TextureAtlas.class);
			spriteBatch.draw(atlas.findRegion(instructions.getTextureRegion()), x, y, 0, 0, width, height, 1, 1, 0);
		}
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
