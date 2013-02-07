package platformer.core.model.gamestate.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import platformer.core.model.GameObject;
import platformer.core.model.GameState;
import platformer.core.model.Level;
import platformer.core.model.SpatialIndex;
import platformer.core.model.systems.Simulatable;
import platformer.core.model.systems.impl.culling.SimpleSpatialIndex;
import platformer.core.renderer.Renderable;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class GameStateImpl implements GameState {

	/**
	 * Keep track of all game objects.
	 */
	private final List<GameObject> gameObjects = new LinkedList<GameObject>();

	/**
	 * Keep track of all {@link Renderable} objects.
	 */
	private final SpatialIndex<Renderable> renderableObjects = new SimpleSpatialIndex<Renderable>(1024);

	/**
	 * Keep track of all {@link Simulatable} objects.
	 */
	private final SpatialIndex<Simulatable> simulatableObjects = new SimpleSpatialIndex<Simulatable>(1024);

	private final List<GameObject> toRemove = new LinkedList<GameObject>();
	private final Map<String, GameObject> objectsById = new TreeMap<String, GameObject>();

	public void addGameObject(GameObject gameObject) {
		gameObjects.add(gameObject);

		if (gameObject.getId() != null) {
			objectsById.put(gameObject.getId(), gameObject);
		}

		if (gameObject instanceof Renderable) {
			final Renderable renderable = (Renderable) gameObject;
			renderableObjects.addObject(renderable);
		}

		if (gameObject instanceof Simulatable) {
			final Simulatable simulatable = (Simulatable) gameObject;
			simulatableObjects.addObject(simulatable);
		}
	}

	public void cleanUp() {

		for (GameObject go : toRemove) {
			go.dispose();
			gameObjects.remove(go);
		}

		toRemove.clear();
	}

	public Array<Renderable> getRenderableObjects(Rectangle aabb) {
		return renderableObjects.getObjects(aabb);
	}

	@Override
	public Array<Simulatable> getSimulatableObjects(Rectangle aabb) {
		return simulatableObjects.getObjects(aabb);
	}

	@Override
	public Iterator<GameObject> iterator() {
		return gameObjects.iterator();
	}

	public void update(Rectangle aabb) {		
		for (GameObject go : gameObjects) {
			if (go.canBeRemoved()) {
				toRemove.add(go);
			}
		}

		renderableObjects.updateObjects(aabb);
		simulatableObjects.updateObjects(aabb);
	}

	@Override
	public void initialize(Level level) {
		for (GameObject go : level.getGameObjects()) {
			addGameObject(go);
		}
	}

	@Override
	public GameObject findGameObjectById(String id) {
		return objectsById.get(id);
	}

	@Override
	public Collection<GameObject> getActiveObjects() {
		// TODO Auto-generated method stub
		return null;
	}
}
