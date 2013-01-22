package platformer.core;

import platformer.core.model.Controllable;
import platformer.core.model.Director;
import platformer.core.model.GameState;
import platformer.core.model.InputHandler;
import platformer.core.model.Level;
import platformer.core.model.Player;
import platformer.core.model.camera.impl.DefaultCamera;
import platformer.core.model.director.impl.DefaultDirector;
import platformer.core.renderer.RendererFactory;
import platformer.core.renderer.viewport.ViewportRenderer;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

public class PlatformerGame implements ApplicationListener {
	Texture texture;
	SpriteBatch batch;
	private Level level;
	private InputHandler inputHandler;
	private Director director;
	private Player player;
	private GameState gameState;
	private ViewportRenderer renderer;
	private DefaultCamera camera;
	private Box2DDebugRenderer debugRenderer;

	private final int LOG_LEVEL = Application.LOG_DEBUG;
	private final int SCREEN_WIDTH = 1024;
	private final int SCREEN_HEIGHT = 768;
	private Controllable playerControlled;
	private RendererFactory rendererFactory;
	private AssetManager assetManager;
	private Matrix4 debugMatrix;

	@Override
	public void create() {
		Gdx.app.setLogLevel(LOG_LEVEL);

		// Setup director;
		director = new DefaultDirector();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void render() {
		// Clear screen to black
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		director.update();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
}
