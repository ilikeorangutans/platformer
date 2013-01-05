package platformer.core;

import platformer.core.model.GameState;
import platformer.core.model.InputHandler;
import platformer.core.model.InputState;
import platformer.core.model.Level;
import platformer.core.model.Player;
import platformer.core.model.Renderer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlatformerGame implements ApplicationListener {
	Texture texture;
	SpriteBatch batch;
	private Level level;
	private InputHandler inputHandler;
	private Renderer renderer;
	private Player player;
	private GameState gameState;

	@Override
	public void create() {
		texture = new Texture(Gdx.files.internal("libgdx-logo.png"));
		batch = new SpriteBatch();

		// Create/load level;
		// Setup game state
		// Setup input handler;
		// Setup renderer (with viewport)
		// Create player

	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void render() {

		InputState inputState = inputHandler.readInput(Gdx.input);
		gameState.update(inputState);
		renderer.render();

		// Gdx.gl.glClearColor(0, 0, 0, 0);
		// Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		// batch.begin();
		// batch.draw(texture, 100, 100);
		// batch.end();
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
