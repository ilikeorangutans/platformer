package platformer.core.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public interface Positionable {

	Vector3 getPosition();

	Rectangle getBounds();

}
