package platformer.core.model.gamestate.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

import platformer.core.model.GameObject;
import platformer.core.model.GameState;
import platformer.core.model.Level;
import platformer.core.model.systems.Cullable;
import platformer.core.model.systems.Simulatable;
import platformer.core.renderer.Renderable;

import com.badlogic.gdx.Gdx;

public class GameStateImpl implements GameState {

	/**
	 * Keep track of all game objects.
	 */
	private final List<GameObject> gameObjects = new LinkedList<GameObject>();

	/**
	 * Keep track of all {@link Renderable} objects.
	 */
	private final List<Renderable> renderableObjects = new LinkedList<Renderable>();

	private final List<GameObject> toRemove = new LinkedList<GameObject>();

	private final Map<String, GameObject> objectsById = new TreeMap<String, GameObject>();

	private Collection<GameObject> simulatableObjects = new LinkedList<GameObject>();

	private Collection<GameObject> cullableObjects = new LinkedList<GameObject>();

	private final Queue<Cullable> activeObjects = new PriorityQueue<Cullable>(
			50, new Comparator<Cullable>() {
				@Override
				public int compare(Cullable o1, Cullable o2) {
					if (o1.isActive() && o2.isActive())
						return 0;

					if (o1.isActive() && !o2.isActive()) {
						return -1;
					}
					return 0;
				}
			});

	public void addGameObject(GameObject gameObject) {
		gameObjects.add(gameObject);

		if (gameObject.getId() != null) {
			Gdx.app.log("gamestate", "adding new object");
			objectsById.put(gameObject.getId(), gameObject);
		}

		if (gameObject instanceof Renderable) {
			final Renderable renderable = (Renderable) gameObject;
			renderableObjects.add(renderable);
		}

		if (gameObject instanceof Simulatable) {
			simulatableObjects.add(gameObject);
		}

		if (gameObject instanceof Cullable) {
			cullableObjects.add(gameObject);
		}
	}

	public void cleanUp() {

		for (GameObject go : toRemove) {
			go.dispose();
			gameObjects.remove(go);
			renderableObjects.remove(go);
			cullableObjects.remove(go);
		}

		toRemove.clear();
	}

	public Collection<Renderable> getRenderableObjects() {
		return renderableObjects;
	}

	@Override
	public Iterator<GameObject> iterator() {
		return gameObjects.iterator();
	}

	public void update() {
		for (GameObject go : gameObjects) {
			if (go.canBeRemoved()) {
				toRemove.add(go);
			}
		}
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
	public Collection<GameObject> getSimulatableObjects() {
		return simulatableObjects;
	}

	@Override
	public Collection<GameObject> getCullableObjects() {
		return cullableObjects;
	}

	@Override
	public Collection<GameObject> getActiveObjects() {
		return null;
	}
}
