package platformer.core.model.inputhandler.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import platformer.core.model.InputHandler;
import platformer.core.model.command.Command;
import platformer.core.model.command.Movecommand;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;

public class DefaultInputHandler implements InputHandler {
	private Collection<Command> currentState;
	private Input input;

	public DefaultInputHandler(Input input) {
		this.input = input;
		currentState = new ArrayList<Command>();

		Gdx.app.debug("DefaultInputHandler", "Initialized and ready to roll!");
	}

	@Override
	public Collection<Command> readInput() {
		currentState.clear();

		//
		// TODO: Split off configuration into a separate module
		//

		// Move Left
		if (input.isKeyPressed(Input.Keys.A)
				|| input.isKeyPressed(Input.Keys.LEFT)) {
			Gdx.app.debug("DefaultInputHandler", "Left key pressed");
			currentState.add(new Movecommand(new Vector3(-1, 0, 0)));
		}

		// Move Right
		if (input.isKeyPressed(Input.Keys.D)
				|| input.isKeyPressed(Input.Keys.RIGHT)) {
			Gdx.app.debug("DefaultInputHandler", "Right key pressed");
			currentState.add(new Movecommand(new Vector3(1, 0, 0)));
		}

		// Move Up
		if (input.isKeyPressed(Input.Keys.W)
				|| input.isKeyPressed(Input.Keys.UP)) {
			Gdx.app.debug("DefaultInputHandler", "Up key pressed");
			currentState.add(new Movecommand(new Vector3(0, 1, 0)));
		}

		// Move Down
		if (input.isKeyPressed(Input.Keys.S)
				|| input.isKeyPressed(Input.Keys.DOWN)) {
			Gdx.app.debug("DefaultInputHandler", "Down key pressed");
			currentState.add(new Movecommand(new Vector3(0, -1, 0)));
		}

		return currentState;
	}
}