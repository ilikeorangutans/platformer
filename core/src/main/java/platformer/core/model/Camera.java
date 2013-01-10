package platformer.core.model;

import com.badlogic.gdx.math.Rectangle;

import platformer.core.model.systems.Positionable;

public interface Camera {

	void update();

	void setTarget(Positionable target);

	Rectangle getViewportBounds();

}
