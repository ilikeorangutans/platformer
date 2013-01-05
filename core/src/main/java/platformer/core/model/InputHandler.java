package platformer.core.model;

import java.util.Collection;

import platformer.core.model.command.Command;

import com.badlogic.gdx.Input;

public interface InputHandler {
		
	Collection<Command> readInput();

}
