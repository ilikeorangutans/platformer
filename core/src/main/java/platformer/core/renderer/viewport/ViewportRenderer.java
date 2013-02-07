package platformer.core.renderer.viewport;

import java.util.Collection;

import com.badlogic.gdx.utils.Array;

import platformer.core.renderer.Renderable;

public interface ViewportRenderer {

	void render(Array<Renderable> renderSet);

}
