package platformer.java;

import platformer.core.PlatformerGame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class PlatformerGameDesktop {
	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.useGL20 = true;
		config.width = 1280;
		config.height = 1024;
		new LwjglApplication(new PlatformerGame(), config);
	}
}
