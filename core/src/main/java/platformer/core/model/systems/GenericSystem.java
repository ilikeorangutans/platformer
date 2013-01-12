package platformer.core.model.systems;

import java.util.Collection;

import platformer.core.model.GameObject;

public interface GenericSystem {

	void update(Collection<GameObject> list);

}
