package platformer.core.model.systems;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public interface Positionable {
	
	void setPosition(Vector3 position);
	
	Vector3 getPosition();

	Rectangle getBounds();

}
