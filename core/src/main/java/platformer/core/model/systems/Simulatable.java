package platformer.core.model.systems;

import com.badlogic.gdx.physics.box2d.Body;

public interface Simulatable extends Movable {
	
	Body getPhysicsBody();
	
}
