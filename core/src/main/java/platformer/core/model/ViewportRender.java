package platformer.core.model;

import java.util.Collection;

import platformer.core.renderer.Renderable;

public interface ViewportRender {

	void render(Collection<Renderable> renderableObjects);

}
