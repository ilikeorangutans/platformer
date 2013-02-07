package platformer.core.renderer;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import platformer.core.renderer.impl.AbstractRenderInstructions.TextureType;


public interface RendererInstructions {
	
	String getTextureName();

	TextureType getTextureType();
	
	String getTextureRegion();

	int getFrame();
	
	void setFrame(int frame);
}
