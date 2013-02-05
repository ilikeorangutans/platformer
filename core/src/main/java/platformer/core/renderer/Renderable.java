package platformer.core.renderer;

import platformer.core.model.systems.Positionable;

public interface Renderable extends Positionable {

	/**
	 * Returns the {@link RendererInstructions} to be used for rendering this
	 * object.
	 * 
	 * @return
	 */
	RendererInstructions getRendererInstructions();

}
