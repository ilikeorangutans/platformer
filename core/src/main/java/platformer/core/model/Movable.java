package platformer.core.model;

import com.badlogic.gdx.math.Vector3;

public interface Movable extends Positionable {
	public void applyVelocity(Vector3 vector);
}