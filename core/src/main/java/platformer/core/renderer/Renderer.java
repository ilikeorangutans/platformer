package platformer.core.renderer;

import platformer.core.model.Renderable;

/**
 * Renders a single {@link Renderable} object.
 * 
 * @author Jakob Külzer
 * 
 */
public interface Renderer {

	void render(Renderable renderable);

}
