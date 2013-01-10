package platformer.core.renderer;

import platformer.core.model.systems.Cullable;
import platformer.core.model.systems.Positionable;

public interface Renderable extends Positionable, Cullable {

	/**
	 * Returns a string naming the texture to render this object.
	 * 
	 * @return
	 */
	String getTextureName();

	/**
	 * Returns the {@link RendererInstructions} to be used for rendering this
	 * object.
	 * 
	 * @return
	 */
	RendererInstructions getRendererInstructions();

}
