package platformer.core.model;

import platformer.core.model.systems.Positionable;

public interface Camera {

	void update();

	void setTarget(Positionable target);

}
