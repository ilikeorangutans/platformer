package platformer.core.model.command;

import platformer.core.model.GameObject;
import platformer.core.model.Movable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;

public class MoveCommand extends AbstractCommand {

	private final Vector3 vector3;

	public MoveCommand(String targetUID, Vector3 vector3) {
		super(targetUID);
		this.vector3 = vector3;
	}

	public void execute(Object object) {
		if (object instanceof Movable) {
			Movable obj = (Movable) object; 
			obj.applyVelocity(vector3);
		} else {
			Gdx.app.error("Moveable", "Can not apply to a non movable object!");
		}
	}

}
