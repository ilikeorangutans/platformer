package platformer.core.renderer.impl;

import platformer.core.renderer.Renderable;
import platformer.core.renderer.Renderer;

import com.badlogic.gdx.graphics.Camera;

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

	@Override
	public void initialize(Camera camera) {
	}

}
