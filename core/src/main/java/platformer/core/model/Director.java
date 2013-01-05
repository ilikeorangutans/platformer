package platformer.core.model;

import java.util.Collection;

import platformer.core.model.command.Command;

public interface Director {

	public void update();
	
	public void addCommand(Command command);
	
	public void addCommand(Collection<Command> command);
	
	public GameState getGameState();
	
}
