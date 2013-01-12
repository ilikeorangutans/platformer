package platformer.core.renderer;

import platformer.core.model.systems.GenericSystem;

/**
 * Describes the currently visible portion to be rendered. A renderset groups
 * {@link Renderable}s by their z-index and their texture.
 * 
 * @author Jakob Külzer
 * 
 */
public interface RenderSet extends GenericSystem, Iterable<Renderable> {

	void add(Renderable renderable);

}
