package platformer.core.renderer.impl.asset;

import platformer.core.renderer.Renderer;
import platformer.core.renderer.RendererFactory;
import platformer.core.renderer.RendererInstructions;
import platformer.core.renderer.impl.BackgroundCloudRendererInstructions;
import platformer.core.renderer.impl.background.BackgroundCloudRenderer;

import com.badlogic.gdx.assets.AssetManager;

public class AssetRendererFactory implements RendererFactory {

	private final Renderer renderer;
	private BackgroundCloudRenderer backgroundCloudRenderer;

	public AssetRendererFactory(AssetManager assetManager) {
		renderer = new TextureRenderer(assetManager);
		backgroundCloudRenderer = new BackgroundCloudRenderer();
	}

	@Override
	public Renderer findRenderer(RendererInstructions instructions) {

		if (instructions instanceof BackgroundCloudRendererInstructions) {
			return backgroundCloudRenderer;
		}

		return renderer;
	}

}
