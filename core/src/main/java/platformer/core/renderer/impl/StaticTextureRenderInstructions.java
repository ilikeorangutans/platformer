package platformer.core.renderer.impl;

import platformer.core.renderer.RendererInstructions;

/**
 * {@link RendererInstructions} for a static texture.
 * 
 * @author Jakob Külzer
 * 
 */
public class StaticTextureRenderInstructions extends AbstractRenderInstructions {

	private final String name;

	public StaticTextureRenderInstructions(String name) {
		this.name = name;
	}

	@Override
	public String getTextureName() {
		return name;
	}

}
