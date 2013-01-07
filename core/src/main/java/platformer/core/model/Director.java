package platformer.core.model;

import java.util.Collection;

import com.badlogic.gdx.utils.Array;

import platformer.core.model.command.Command;
import platformer.core.model.systems.impl.physics.PhysicsSystem;

public interface Director {

	public void update();
	
	public void addCommand(Command command);
	
	public void addCommand(Array<Command> command);
	
	public GameState getGameState();

	public PhysicsSystem getPhysicsSystem();
	
}
