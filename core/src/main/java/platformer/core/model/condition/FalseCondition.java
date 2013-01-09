package platformer.core.model.condition;

import platformer.core.model.GameState;

/**
 * Condition that always returns false.
 * 
 * @author Jakob Külzer
 * 
 */
public class FalseCondition implements Condition {

	@Override
	public boolean isMet(GameState gameState) {
		// So negative!!
		return false;
	}

}
