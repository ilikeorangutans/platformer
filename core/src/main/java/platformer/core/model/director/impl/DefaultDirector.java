package platformer.core.model.director.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import platformer.core.model.Director;
import platformer.core.model.GameObject;
import platformer.core.model.GameState;
import platformer.core.model.Level;
import platformer.core.model.command.Command;
import platformer.core.model.gameobject.impl.DummyCharacter;
import platformer.core.model.gameobject.impl.SimulatableGameObject;
import platformer.core.model.gamestate.impl.GameStateImpl;
import platformer.core.model.level.impl.DummyLevel;

public class DefaultDirector implements Director {
	final private GameState gameState;
	private Collection<Command> commandList = new ArrayList<Command>();
	
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
		GameObject object;
		
		//apply commands to target objects
		for (Command command : commandList) {
			 object = gameState.findGameObjectById(command.getTargetUID());
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
	public void addCommand(Collection<Command> commands) {
		commandList.addAll(commands);
	}

	@Override
	public GameState getGameState() {
		return gameState;
	}

}
