package platformer.core.model.level.impl;

import java.util.Collection;
import java.util.LinkedList;

import platformer.core.model.GameObject;
import platformer.core.model.Level;
import platformer.core.model.gameobject.impl.DummyGameObject;

public class DummyLevel implements Level {

	private Collection<GameObject> gameObjects;

	public DummyLevel() {
		gameObjects = new LinkedList<GameObject>();

		gameObjects.add(new DummyGameObject());
	}

	@Override
	public Collection<GameObject> getGameObjects() {
		return gameObjects;
	}

}
