package platformer.core.renderer.viewport;

import java.util.Collection;

import platformer.core.renderer.Renderable;

public interface ViewportRenderer {

	void render(Collection<Renderable> renderSet);

}
