package platformer.core.model.director.impl;

import platformer.core.model.Director;
import platformer.core.model.GameState;
import platformer.core.model.Level;
import platformer.core.model.command.Command;
import platformer.core.model.gameobject.impl.ExampleGameObject;
import platformer.core.model.gamestate.impl.GameStateImpl;
import platformer.core.model.level.impl.DummyLevel;
import platformer.core.model.systems.Simulatable;
import platformer.core.model.systems.impl.physics.PhysicsSystem;
import platformer.core.model.systems.impl.physics.bodies.RegularPlayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class DefaultDirector implements Director {
	final private GameState gameState;
	private Array<Command> commandList = new Array<Command>();
	private PhysicsSystem physicsSystem;
	
	public DefaultDirector(){
		//Load Level
		Level level = new DummyLevel(); 
		
		physicsSystem = new PhysicsSystem(level.getGravity());

		// Setup game state
		level.initialize(physicsSystem); //Until i figure out a workaround, need to pass in the system in order to create bodies from within.
		gameState = new GameStateImpl();
		gameState.initialize(level);
		
		Vector3 testPosition = new Vector3(100, 100, 0);
		Rectangle testBound = new Rectangle(0, 0, 64, 64);
		ExampleGameObject object = new ExampleGameObject(testPosition, testBound, physicsSystem.createBody(RegularPlayer.class.getName(), testPosition, testBound));
		
		gameState.addGameObject(object);
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
		physicsSystem.update(gameState.getSimulatableObjects());
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
	
	public PhysicsSystem getPhysicsSystem() {
		return physicsSystem;
	}

}
