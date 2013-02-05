package platformer.core.model.level.impl;

import java.util.Collection;
import java.util.LinkedList;

import platformer.core.model.GameObject;
import platformer.core.model.Level;
import platformer.core.model.condition.Condition;
import platformer.core.model.condition.FalseCondition;
import platformer.core.model.condition.NotCondition;
import platformer.core.model.condition.PlayerAliveCondition;
import platformer.core.model.gameobject.impl.LevelTile;
import platformer.core.model.gameobject.impl.background.Cloud;
import platformer.core.model.systems.impl.physics.PhysicsSystem;
import platformer.core.model.systems.impl.physics.bodies.Square;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;

public class TestDummyLevel implements Level {

	private static final int TILE_WIDTH = 20;
	private Collection<GameObject> gameObjects;

	public TestDummyLevel() {
		gameObjects = new LinkedList<GameObject>();
	}

	public void initialize(PhysicsSystem physicsSystem) {

	}

	@Override
	public Collection<GameObject> getGameObjects() {
		return gameObjects;
	}

	@Override
	public Vector2 getGravity() {
		return new Vector2(0, 0);
	}

	@Override
	public Condition getWinningCondition() {
		return new FalseCondition();
	}

	@Override
	public Condition getLosingCondition() {
		return new NotCondition(new PlayerAliveCondition("player"));
	}

}
