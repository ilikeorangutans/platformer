package platformer.core.model.director.impl;

import platformer.core.model.Director;
import platformer.core.model.GameState;
import platformer.core.model.Level;
import platformer.core.model.command.Command;
import platformer.core.model.gameobject.impl.DummyCharacter;
import platformer.core.model.gameobject.impl.SimulatableGameObject;
import platformer.core.model.gamestate.impl.GameStateImpl;
import platformer.core.model.level.impl.DummyLevel;

import com.badlogic.gdx.utils.Array;

public class DefaultDirector implements Director {
	final private GameState gameState;
	private Array<Command> commandList = new Array<Command>();
	
	public DefaultDirector(){
		// Setup game state
		DummyCharacter playerControlled = new DummyCharacter();
		SimulatableGameObject objectSim = new SimulatableGameObject();
		Level level = new DummyLevel();
		gameState = new GameStateImpl();
		
		gameState.initialize(level);
		gameState.addGameObject(playerControlled);
		gameState.addGameObject(objectSim);
	}
	
	public void update() {
		Object object;
		
		//apply commands to target objects
		for (Command command : commandList) {
			if("gamestate".equals(command.getTargetUID())) {
				object = gameState;	
			} else {
				object = gameState.findGameObjectById(command.getTargetUID());
			}
			command.execute(object);
		}
		
		//execute and wipe
		gameState.update();
		commandList.clear();
	}

	@Override
	public void addCommand(Command command) {
		commandList.add(command);
	}

	@Override
	public void addCommand(Array<Command> commands) {
		commandList.addAll(commands);
	}

	@Override
	public GameState getGameState() {
		return gameState;
	}

}
