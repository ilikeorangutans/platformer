package platformer.core.model.command;

import platformer.core.model.GameObject;
import platformer.core.model.systems.Movable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;

public class MoveCommand extends AbstractCommand {

	private final Vector3 vector;

	public MoveCommand(String targetUID, Vector3 vector) {
		super(targetUID);
		this.vector = vector;
	}

	public void execute(Object object) {
		if (object instanceof Movable) {
			Movable obj = (Movable) object; 
			obj.move(vector.cpy());
		} else {
			Gdx.app.error("Moveable", "Can not apply to a non movable object!");
		}
	}

}
