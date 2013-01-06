package platformer.core.model.command;

import platformer.core.model.GameState;
import platformer.core.model.gameobject.impl.DummyGameObject;
import platformer.core.model.gameobject.impl.SimulatableGameObject;

import com.badlogic.gdx.math.Vector3;

public class CreateCommand extends AbstractCommand{
	
	
	private Vector3 position;

	public CreateCommand(String targetUID, Vector3 position) {
		super(targetUID);
		
		this.position = position;
	}

	@Override
	public void execute(Object o) {
			((GameState) o).addGameObject(new SimulatableGameObject(position));
	}

}
