package platformer.core.model;

import platformer.core.model.command.Command;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.Array;

public interface InputHandler extends InputProcessor {
		
	Array<Command> readInput();

}
