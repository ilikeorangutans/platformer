package platformer.core.renderer;

/**
 * Produces {@link Renderer} objects.
 * 
 * @author Jakob Külzer
 * 
 */
public interface RendererFactory {

	Renderer findRenderer(RendererInstructions instructions);

}
