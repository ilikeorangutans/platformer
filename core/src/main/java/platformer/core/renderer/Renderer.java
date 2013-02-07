package platformer.core.renderer;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Renders a single {@link Renderable} object.
 * 
 * @author Jakob Külzer
 * 
 */
public interface Renderer {

	void initialize(Camera camera, SpriteBatch batch);

	void finish();

	void render(Renderable renderable);

}
