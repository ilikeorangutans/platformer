package platformer.core.renderer;

import platformer.core.model.systems.Positionable;

public interface Renderable extends Positionable {

	/**
	 * Returns a string naming the texture to render this object.
	 * 
	 * @return
	 */
	String getTextureName();

}
