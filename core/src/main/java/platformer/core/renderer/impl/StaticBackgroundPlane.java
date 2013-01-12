package platformer.core.renderer.impl;

import platformer.core.renderer.BackgroundPlane;
import platformer.core.renderer.RendererInstructions;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class StaticBackgroundPlane implements BackgroundPlane {

	private RendererInstructions rendererInstructions;
	private Rectangle bounds;
	private Vector3 position;

	public StaticBackgroundPlane() {
		rendererInstructions = new ImmutableRendererInstructions("clouds");
		bounds = new Rectangle(0, 0, 1024, 768);
		position = new Vector3(0, 0, -10);
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
	public RendererInstructions getRendererInstructions() {
		return rendererInstructions;
	}

	@Override
	public void setPosition(Vector3 position) {
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
	public boolean isActive() {
		return true;
	}

	@Override
	public void setIsActive(boolean state) {
	}

}
