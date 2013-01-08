package platformer.core.model.gameobject.impl;

import java.awt.geom.RectangularShape;

import platformer.core.model.GameObject;
import platformer.core.model.systems.Positionable;
import platformer.core.model.systems.Simulatable;
import platformer.core.renderer.Renderable;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class LevelTile implements GameObject, Positionable, Renderable,
		Simulatable {

	private Vector3 position;
	private final Rectangle bounds;
	private ShapeRenderer renderer;
	private Body body;

	public LevelTile(Vector3 position, Rectangle bounds, Body body) {
		this.position = position;
		this.bounds = bounds;
		this.body = body;
	}

	@Override
	public Vector3 getPosition() {
		return position;
	}

	@Override
	public Rectangle getBounds() {
		return bounds;
	}

	@Override
	public boolean canBeRemoved() {
		return false;
	}

	@Override
	public void dispose() {
	}

	@Override
	public String getId() {
		return null;
	}

	@Override
	public String getTextureName() {
		return "grass";
	}

	@Override
	public void move(Vector3 vector) {
		
	}

	@Override
	public Body getPhysicsBody() {
		return body;
	}

	@Override
	public void setPosition(Vector3 position) {
		this.position = position;
	}

	@Override
	public boolean isGrounded() {
		return true;
	}

	@Override
	public void setIsGrounded(boolean bool) {
		return;
	}
}
