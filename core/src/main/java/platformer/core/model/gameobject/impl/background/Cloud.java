package platformer.core.model.gameobject.impl.background;

import platformer.core.model.GameObject;
import platformer.core.renderer.Renderable;
import platformer.core.renderer.RendererInstructions;
import platformer.core.renderer.impl.BackgroundCloudRendererInstructions;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Cloud implements GameObject, Renderable {

	private Rectangle bounds;
	private String id;
	private Vector3 position;
	private RendererInstructions rendererInstructions;
	private boolean active;

	public Cloud(Vector3 position) {
		this.position = position;
		this.bounds = new Rectangle(0, 0, 64, 64);
		rendererInstructions = new BackgroundCloudRendererInstructions();
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
		return id;
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
	public void setPosition(Vector3 position) {

	}

}
