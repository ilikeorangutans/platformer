package platformer.core.model.condition;


public abstract class BinaryCondition implements Condition {

	protected final Condition right;
	protected final Condition left;

	public BinaryCondition(Condition left, Condition right) {
		this.left = left;
		this.right = right;
	}

}
