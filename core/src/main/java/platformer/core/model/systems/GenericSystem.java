package platformer.core.model.systems;

import java.util.Collection;

import com.badlogic.gdx.utils.Array;

import platformer.core.model.GameObject;

public interface GenericSystem<T> {

	void update(Array<T> list);
	
}
