package platformer.core.model.viewportrender.impl;

import java.util.Collection;

import platformer.core.model.Renderable;
import platformer.core.model.ViewportRender;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class DefaultViewportRender implements ViewportRender {
	Graphics graphics;
	Camera camera;
	
	public DefaultViewportRender(Graphics graphics, Camera camera) {
		this.graphics = graphics;
		this.camera = camera;
	}

	@Override
	public void render(Collection<Renderable> renderableObjects) {		
		camera.update();
		
		for (Renderable renderable : renderableObjects) {
			renderable.render(graphics);
		}
	}
}
