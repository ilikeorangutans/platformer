package platformer.core.renderer;

import platformer.core.model.systems.Cullable;
import platformer.core.model.systems.Positionable;

public interface Renderable extends Positionable, Cullable {

	/**
	 * Returns the {@link RendererInstructions} to be used for rendering this
	 * object.
	 * 
	 * @return
	 */
	RendererInstructions getRendererInstructions();

}
