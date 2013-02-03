package platformer.core;

import platformer.core.model.Director;
import platformer.core.model.director.impl.DefaultDirector;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

public class PlatformerGame implements ApplicationListener {

	private Director director;

	private final int LOG_LEVEL = Application.LOG_DEBUG;

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
