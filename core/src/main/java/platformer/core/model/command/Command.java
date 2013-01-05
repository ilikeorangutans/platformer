package platformer.core.model.command;

import platformer.core.model.GameObject;
import platformer.core.model.GameState;

public interface Command {
	
	String getTargetUID();
	
	void execute(GameObject object);

}
