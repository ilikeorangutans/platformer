package platformer.core.model.command;

import platformer.core.model.GameState;

import com.badlogic.gdx.math.Vector3;

public class Movecommand implements Command {

	private final Vector3 vector3;

	public Movecommand(Vector3 vector3) {
		this.vector3 = vector3;
	}

	@Override
	public void execute(GameState gameState) {
		// Get player from gameState
		// Player player = gameState.getPlayer();
		
		// Update player with new vector
		// player.applyForces(vector3);
	}

}
