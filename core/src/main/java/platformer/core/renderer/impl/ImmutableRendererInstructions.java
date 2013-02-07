package platformer.core.renderer.impl;

import platformer.core.renderer.RendererInstructions;

public class ImmutableRendererInstructions implements RendererInstructions {

	private final String textureName;

	public ImmutableRendererInstructions(String textureName) {
		this.textureName = textureName;
	}

	@Override
	public String getTextureName() {
		return textureName;
	}
 
}
