package platformer.core.renderer.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import platformer.core.renderer.RendererInstructions;

public class BackgroundCloudRendererInstructions extends AbstractRenderInstructions {
	
	public BackgroundCloudRendererInstructions() {
		frame = (int) Math.floor(Math.random() * 3);
	}
	
	@Override
	public String getTextureName() {
		return "background";
	}

	@Override
	public TextureType getTextureType() {
		return TextureType.SPRITESHEET;
	}
	
	@Override
	public String getTextureRegion() {
		return "clouds-"+getFrame();
	}
	
	@Override
	public int getFrame() {
		return frame;
	}
	
}
