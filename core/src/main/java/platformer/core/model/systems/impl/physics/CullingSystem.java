package platformer.core.model.systems.impl.physics;

import java.util.Collection;

import platformer.core.model.Camera;
import platformer.core.model.GameObject;
import platformer.core.model.systems.Cullable;
import platformer.core.model.systems.GenericSystem;
import platformer.core.model.systems.Positionable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class CullingSystem implements GenericSystem {

	private Camera view;
	private Rectangle viewportBounds;
	private final float EXTRA_SCREEN_TIMES = 1.5f; // All around, keep that in
												// mind.

	public CullingSystem(Camera view) {
		this.view = view;
	}

	@Override
	public void update(Collection<GameObject> list) {
		// Get current viewport
		viewportBounds = view.getViewportBounds();

		// Now the viewport has to be expanded to include a little bit all
		// around.
		viewportBounds.x = viewportBounds.x
				- (viewportBounds.width * EXTRA_SCREEN_TIMES);
		viewportBounds.y = viewportBounds.y
				- (viewportBounds.height * EXTRA_SCREEN_TIMES);
		
		if (EXTRA_SCREEN_TIMES != 0) {
			viewportBounds.width *= EXTRA_SCREEN_TIMES * 2;
			viewportBounds.height *= EXTRA_SCREEN_TIMES * 2;
		}

//		Gdx.app.log("wtf", "x:" + viewportBounds.x + ", y:" + viewportBounds.y
//				+ ", w: " + viewportBounds.width + ", h: "
//				+ viewportBounds.height);

		for (GameObject gameObject : list) {
			Vector3 position = new Vector3(((Positionable) gameObject).getPosition());
			
			if (gameObject.getId() == "player") {
				Gdx.app.log("xxx", position.x + " ::: " + viewportBounds.x);
//				Gdx.app.log("xxx",
//						String.valueOf(position.y >= viewportBounds.y));
			}
			boolean fitsInRenderArea = position.x >= viewportBounds.x
					&& position.y >= viewportBounds.y
					&& position.x <= viewportBounds.x + viewportBounds.width
					&& position.y <= viewportBounds.y + viewportBounds.height;

			((Cullable) gameObject).setIsActive(fitsInRenderArea);
		}
	}

}
