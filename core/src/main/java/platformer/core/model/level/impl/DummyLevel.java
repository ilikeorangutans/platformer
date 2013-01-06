package platformer.core.model.level.impl;

import java.util.Collection;
import java.util.LinkedList;

import platformer.core.model.GameObject;
import platformer.core.model.Level;
import platformer.core.model.gameobject.impl.DummyGameObject;
import platformer.core.model.gameobject.impl.LevelTile;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class DummyLevel implements Level {

	private Collection<GameObject> gameObjects;

	public DummyLevel() {
		gameObjects = new LinkedList<GameObject>();

		gameObjects.add(new DummyGameObject());

		for (int i = 0; i < 200; i++) {
			gameObjects.add(new LevelTile(new Vector3(i * 10, 0, 0),
					new Rectangle(0, 0, MathUtils.random(10, 70), MathUtils.random(10, 70))));
		}
		
		for (int i = 0; i < 20; i++) {
			gameObjects.add(new LevelTile(new Vector3(i * 10, 200, 0),
					new Rectangle(0, 0, 10, 10)));
		}

	}

	@Override
	public Collection<GameObject> getGameObjects() {
		return gameObjects;
	}

	@Override
	public Vector2 getGravity() {
		return new Vector2(0, -100);
	}

}
