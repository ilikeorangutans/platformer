package platformer.core.renderer.impl.asset;

import platformer.core.renderer.Renderable;
import platformer.core.renderer.Renderer;
import platformer.core.renderer.RendererFactory;

import com.badlogic.gdx.assets.AssetManager;

public class AssetRendererFactory implements RendererFactory {

	private final AssetManager assetManager;

	public AssetRendererFactory(AssetManager assetManager) {
		this.assetManager = assetManager;
	}

	@Override
	public Renderer findRenderer(Class<? extends Renderable> clazz) {
		return null;
	}

}
