package platformer.core.model;

import java.util.Collection;

import platformer.core.model.command.Command;

public interface GameState {

	void update(Collection<Command> inputState);

}
