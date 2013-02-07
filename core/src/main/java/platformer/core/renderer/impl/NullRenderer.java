package platformer.core.renderer.impl;

import platformer.core.renderer.Renderable;
import platformer.core.renderer.Renderer;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Renderer that doesn't do anything.
 * 
 * @author Jakob Külzer
 * 
 */
public class NullRenderer implements Renderer {

	public static final Renderer INSTANCE = new NullRenderer();

	@Override
	public void render(Renderable renderable) {
	}

	@Override
	public void finish() {
	}

	@Override
	public void initialize(Camera camera, SpriteBatch batch) {
		
	}

}
