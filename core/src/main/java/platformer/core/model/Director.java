package platformer.core.model;

import platformer.core.model.command.Command;
import platformer.core.model.systems.impl.physics.PhysicsSystem;

import com.badlogic.gdx.utils.Array;

public interface Director {

	public void update();

	public void addCommand(Command command);

	public void addCommand(Array<Command> command);

	public GameState getGameState();

	public PhysicsSystem getPhysicsSystem();

}
