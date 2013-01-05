package platformer.core.renderer.impl;

import platformer.core.model.Renderable;
import platformer.core.renderer.Renderer;

/**
 * Renderer that doesn't do anything.
 * 
 * @author Jakob Külzer
 * 
 */
public class NullRenderer implements Renderer {

	public static final Renderer INSTANCE = new NullRenderer();

	public NullRenderer() {
	}

	@Override
	public void render(Renderable renderable) {
	}

}
