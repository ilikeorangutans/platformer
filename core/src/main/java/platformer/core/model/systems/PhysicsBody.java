package platformer.core.model.systems;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public interface PhysicsBody {
		Body create(World world, Vector3 position, Rectangle bounds);
}
