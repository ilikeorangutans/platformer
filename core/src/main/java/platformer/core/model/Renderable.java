package platformer.core.model;

import com.badlogic.gdx.Graphics;

public interface Renderable extends Positionable {

	@Deprecated
	public void render(Graphics graphics);

}
