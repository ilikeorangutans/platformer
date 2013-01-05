package platformer.core.model;

public interface GameObject {

	/**
	 * Indicates whether this object can be removed from the game. Each game
	 * object is required to set this to true when it reaches end of life. Once
	 * {@link GameState#cleanUp()} gets called, this object's {@link #dispose()}
	 * will be called. This instance will not be used after this method returns
	 * true.
	 */
	boolean canBeRemoved();

	/**
	 * Release all resources associated with this object.
	 */
	void dispose();

	/**
	 * Returns a identifier for this game object.
	 * 
	 * @return
	 */
	String getId();

	/**
	 * Update the game object. Called for each iteration in the gameloop.
	 */
	void update();

}
