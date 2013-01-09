package platformer.core.renderer;

import com.badlogic.gdx.graphics.Camera;

/**
 * Renders a single {@link Renderable} object.
 * 
 * @author Jakob Külzer
 * 
 */
public interface Renderer {

	void initialize(Camera camera);

	void finish();

	void render(Renderable renderable);

}
