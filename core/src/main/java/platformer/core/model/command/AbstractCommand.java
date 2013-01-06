package platformer.core.model.command;

import com.badlogic.gdx.Gdx;

import platformer.core.model.GameObject;

public abstract class AbstractCommand implements Command {
	final private String targetUID;
	
	public AbstractCommand(String targetUID) {
		this.targetUID = targetUID;
	}
	
	@Override
	public String getTargetUID() {
		return targetUID;
	}

}
