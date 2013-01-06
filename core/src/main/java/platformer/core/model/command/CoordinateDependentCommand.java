package platformer.core.model.command;

import com.badlogic.gdx.math.Vector3;


public interface CoordinateDependentCommand {
	void setPosition(Vector3 position);
}
