package platformer.core.model.condition;

import platformer.core.model.GameObject;
import platformer.core.model.GameState;

public class PlayerAliveCondition implements Condition {

	private final String playerId;

	public PlayerAliveCondition(String playerId) {
		this.playerId = playerId;
	}

	@Override
	public boolean isMet(GameState gameState) {
		GameObject player = gameState.findGameObjectById(playerId);

		// Check characters health!

		return true;
	}

}
