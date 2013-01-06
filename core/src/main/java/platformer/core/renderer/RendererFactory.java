package platformer.core.renderer;

import platformer.core.model.Renderable;

/**
 * Produces {@link Renderer} objects.
 * 
 * @author Jakob Külzer
 * 
 */
public interface RendererFactory {

	Renderer findRenderer(Class<? extends Renderable> clazz);

}
