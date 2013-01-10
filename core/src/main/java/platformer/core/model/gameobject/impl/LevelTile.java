package platformer.core.model.gameobject.impl;

import platformer.core.model.GameObject;
import platformer.core.model.systems.Positionable;
import platformer.core.model.systems.Simulatable;
import platformer.core.renderer.Renderable;
import platformer.core.renderer.RendererInstructions;
import platformer.core.renderer.impl.StaticTextureRenderInstructions;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;

public class LevelTile implements GameObject, Positionable, Renderable,
		Simulatable {

	private Vector3 position;
	private final Rectangle bounds;
	private Body body;
	private RendererInstructions rendererInstructions;
	private boolean state = false;

	public LevelTile(Vector3 position, Rectangle bounds, Body body) {
		this(position, bounds, body, "grass_single");
	}

	public LevelTile(Vector3 position, Rectangle bounds, Body body,
			String textureName) {
		this.position = position;
		this.bounds = bounds;
		this.body = body;
		this.rendererInstructions = new StaticTextureRenderInstructions(
				textureName);
	}

	@Override
	public boolean canBeRemoved() {
		return false;
	}

	@Override
	public void dispose() {
	}

	@Override
	public Rectangle getBounds() {
		return bounds;
	}

	@Override
	public String getId() {
		return null;
	}

	@Override
	public Body getPhysicsBody() {
		return body;
	}

	@Override
	public Vector3 getPosition() {
		return position;
	}

	@Override
	public RendererInstructions getRendererInstructions() {
		return rendererInstructions;
	}

	@Override
	public String getTextureName() {
		return "grass";
	}

	@Override
	public boolean isGrounded() {
		return true;
	}

	@Override
	public void move(Vector3 vector) {

	}

	@Override
	public void setIsGrounded(boolean bool) {
		return;
	}

	@Override
	public void setPosition(Vector3 position) {
		this.position = position;
	}

	@Override
	public boolean isActive() {
		return state;
	}

	@Override
	public void setIsActive(boolean state) {
		this.state  = state;
	}
}
