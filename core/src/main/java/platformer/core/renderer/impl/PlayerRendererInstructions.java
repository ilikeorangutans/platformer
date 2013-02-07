package platformer.core.renderer.impl;

import com.badlogic.gdx.Gdx;

public class PlayerRendererInstructions extends AbstractRenderInstructions {

	private final int TOTAL_FRAMES = 16;
	private final float FRAME_TIME = 1f / TOTAL_FRAMES / 2;
	private float timeElapsed = 0;

	@Override
	public String getTextureName() {
		return "characters";
	}

	@Override
	public TextureType getTextureType() {
		return TextureType.SPRITESHEET;
	}

	@Override
	public String getTextureRegion() {
		return "player-" + (getFrame() + 1);
	}

	@Override
	public int getFrame() {
		timeElapsed += Gdx.graphics.getDeltaTime();

		if (timeElapsed >= FRAME_TIME) {
			timeElapsed = 0;

			frame++;
			if (frame >= TOTAL_FRAMES) {
				frame = 0;
			}
		}

		return frame;
	}

}
