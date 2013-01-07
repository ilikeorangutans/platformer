package platformer.core.model.command;

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
