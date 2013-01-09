package platformer.core.renderer;

/**
 * Describes the currently visible portion to be rendered. A renderset groups
 * {@link Renderable}s by their z-index and their texture.
 * 
 * @author Jakob Külzer
 * 
 */
public interface RenderSet extends Iterable<Renderable> {

	void add(Renderable renderable);

}
