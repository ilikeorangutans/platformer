package platformer.html;

import platformer.core.PlatformerGame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class PlatformerGameHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new PlatformerGame();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
