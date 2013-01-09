package platformer.core.model.condition;

import platformer.core.model.GameState;

public class NotCondition implements Condition {

	private final Condition wrap;

	public NotCondition(Condition wrap) {
		this.wrap = wrap;
	}

	@Override
	public boolean isMet(GameState gameState) {
		return !wrap.isMet(gameState);
	}

}
