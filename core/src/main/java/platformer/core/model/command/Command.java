package platformer.core.model.command;

import platformer.core.model.GameState;

public interface Command {

	void execute(GameState gameState);

}
