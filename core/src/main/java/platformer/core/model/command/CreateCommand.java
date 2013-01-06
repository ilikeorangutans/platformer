package platformer.core.model.command;

import platformer.core.model.GameState;
import platformer.core.model.gameobject.impl.DummyGameObject;
import platformer.core.model.gameobject.impl.SimulatableGameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;

public class CreateCommand extends AbstractCommand implements CoordinateDependentCommand, ThrottleableCommand {

	private Vector3 position;
	private long throttle;

	public CreateCommand(String targetUID, Vector3 position) {
		super(targetUID);

		this.position = position;
	}
	
	public void setPosition(Vector3 position) {
		this.position = position;
	}

	@Override
	public void execute(Object o) {
		Gdx.app.log("creating object", "x" + position.x + "y" + position.y);
		((GameState) o).addGameObject(
				new SimulatableGameObject(position));
	}

	@Override
	public Command setThrottle(long milliseconds) {
		this.throttle = milliseconds;
		return this;
	}

	@Override
	public long getThrottle() {
		return throttle;
	}
}
