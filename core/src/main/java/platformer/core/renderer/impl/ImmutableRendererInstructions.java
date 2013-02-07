package platformer.core.renderer.impl;


public class ImmutableRendererInstructions extends AbstractRenderInstructions {

	private final String textureName;

	private TextureType textureType;

	private int frame;
	
	public ImmutableRendererInstructions(String textureName, TextureType textureType, int frame) {
		this.textureName = textureName;
		this.textureType = textureType;
		frame = frame;
	}

	@Override
	public String getTextureName() {
		return textureName;
	}
	
	@Override
	public TextureType getTextureType() {
		return textureType;
	}

	@Override
	public int getFrame() {
		return frame;
	}
}
