package platformer.core.model.condition;

import platformer.core.model.GameState;

public class OrCondition extends BinaryCondition {

	public OrCondition(Condition left, Condition right) {
		super(left, right);
	}

	@Override
	public boolean isMet(GameState gameState) {
		return left.isMet(gameState) || right.isMet(gameState);
	}

}
