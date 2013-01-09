package platformer.core.model.inputhandler.impl;

import platformer.core.model.InputHandler;
import platformer.core.model.command.Command;
import platformer.core.model.command.CoordinateDependentCommand;
import platformer.core.model.command.CreateCommand;
import platformer.core.model.command.MoveCommand;
import platformer.core.model.command.ThrottleableCommand;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;

public class DefaultInputHandler implements InputHandler {
	private Array<Command> currentCommandList;
	private Input input;
	private OrthographicCamera camera;
	private Vector3 touchPos = new Vector3(0, 0, 0);
	private ArrayMap<Integer, Command> eventMap;
	private ArrayMap<Integer, Long> throttledEvents;
	private Array<Integer> currentInputState;

	public DefaultInputHandler(Input input, OrthographicCamera camera) {
		this.input = input;
		this.camera = camera;
		currentCommandList = new Array<Command>();
		currentInputState = new Array<Integer>();
		throttledEvents = new ArrayMap<Integer, Long>();

		loadConfig();

		Gdx.app.debug("DefaultInputHandler", "Initialized and ready to roll!");
	}

	private void loadConfig() {
		// TODO Replace with actual config mapping in JSON
		eventMap = new ArrayMap<Integer, Command>();
		eventMap.put(Input.Keys.LEFT, new MoveCommand("player", new Vector3(
				-10, 0, 0)));
		eventMap.put(Input.Keys.RIGHT, new MoveCommand("player", new Vector3(
				10, 0, 0)));
		eventMap.put(Input.Keys.UP, new MoveCommand("player", new Vector3(0,
				10, 0)));
		eventMap.put(Input.Buttons.LEFT, new CreateCommand("gamestate",
				touchPos).setThrottle(500));
	}

	@Override
	public Array<Command> readInput() {
		Command command;
		Long unlockTime;
		long currentTime = System.currentTimeMillis();
		currentCommandList.clear();

		// Gather commands that match current input state
		for (Integer key : currentInputState) {
			command = eventMap.get(key);

			// If the command is CoordinateDependentCommand, then update pointer
			// values
			if (command instanceof CoordinateDependentCommand) {
				((CoordinateDependentCommand) command).setPosition(touchPos);
			}

			// Add command
			if (command != null && !throttledEvents.containsKey(key)) {
				currentCommandList.add(command);
			}

			// If the command is Throttleable.
			// If block expired then unblock
			// Otherwise block it for the next cycle
			if (command instanceof ThrottleableCommand) {
				unlockTime = throttledEvents.get(key);
				if (unlockTime != null) {
					if (currentTime >= unlockTime) {
						throttledEvents.removeKey(key);
					}
				} else {
					unlockTime = System.currentTimeMillis()
							+ ((ThrottleableCommand) command).getThrottle();
					throttledEvents.put(key, unlockTime);
				}
			}

		}

		return currentCommandList;
	}

	@Override
	public boolean keyDown(int keycode) {
		currentInputState.add(keycode);
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		currentInputState.removeValue(keycode, true);
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		currentInputState.add(button);
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		currentInputState.removeValue(button, false);
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		touchPos = new Vector3(screenX, screenY, 0);
		camera.unproject(touchPos);

		return true;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}