package platformer.core.model.condition;

import platformer.core.model.GameState;

/**
 * 
 * @author Jakob Külzer
 * 
 */
public interface Condition {

	/**
	 * Returns true if this condition is fullfilled by the given game state.
	 * 
	 * @param gameState
	 * @return
	 */
	boolean isMet(GameState gameState);

}
