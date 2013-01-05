package platformer.core;

import java.util.Collection;

import platformer.core.model.GameState;
import platformer.core.model.InputHandler;
import platformer.core.model.Level;
import platformer.core.model.Player;
import platformer.core.model.Renderer;
import platformer.core.model.command.Command;
import platformer.core.model.gamestate.impl.GameStateImpl;
import platformer.core.model.level.impl.DummyLevel;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
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

	private final int logLevel = Application.LOG_DEBUG;

	@Override
	public void create() {
		Gdx.app.setLogLevel(logLevel);

		// Create/load level;
		level = new DummyLevel();
		// Setup game state

		gameState = new GameStateImpl();
		gameState.initialize(level);

		// Setup input handler;
		inputHandler = new DefaultInputHandler(Gdx.input);
		// Setup renderer (with viewport)
		// Create player
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void render() {

		Collection<Command> inputState = inputHandler.readInput();
		gameState.update(inputState);
		// renderer.render();

		gameState.cleanUp();

		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
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
