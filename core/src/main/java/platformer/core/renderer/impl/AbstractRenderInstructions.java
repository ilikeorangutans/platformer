package platformer.core.renderer.impl;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import platformer.core.renderer.RendererInstructions;

public abstract class AbstractRenderInstructions implements RendererInstructions {
	protected int frame = 0;
	protected int FRAME_COLS = 1;
	protected int FRAME_ROWS = 1;
	protected TextureRegion textureRegion;
	public static enum TextureType{
		SINGLE,
		SPRITESHEET
	};
	
	@Override
	public TextureType getTextureType() {
		return TextureType.SINGLE;
	}
	
	@Override
	public String getTextureRegion() {
		return "";
	}

	@Override
	public int getFrame() {
		return frame;
	}

	@Override
	public void setFrame(int frame) {
		this.frame = frame;		
	}
	
}
