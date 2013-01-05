package platformer.core.model.level.impl;

import java.util.Collection;
import java.util.LinkedList;

import platformer.core.model.GameObject;
import platformer.core.model.Level;
import platformer.core.model.gameobject.impl.DummyGameObject;
import platformer.core.model.gameobject.impl.LevelTile;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class DummyLevel implements Level {

	private Collection<GameObject> gameObjects;

	public DummyLevel() {
		gameObjects = new LinkedList<GameObject>();

		gameObjects.add(new DummyGameObject());

		for (int i = 0; i < 20; i++) {
			gameObjects.add(new LevelTile(new Vector3(i * 10, 0, 0),
					new Rectangle()));
		}

	}

	@Override
	public Collection<GameObject> getGameObjects() {
		return gameObjects;
	}

}
