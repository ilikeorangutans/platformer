package platformer.core.model;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public interface Simulatable {
	
	Body initialize(World world);
	
}
