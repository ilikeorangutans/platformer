package platformer.core.model.systems;


import com.badlogic.gdx.math.Vector3;

public interface Movable extends Positionable {
	
	void move(Vector3 vector);
	
}