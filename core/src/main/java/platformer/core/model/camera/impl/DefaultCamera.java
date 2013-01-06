package platformer.core.model.camera.impl;

import platformer.core.model.Camera;
import platformer.core.model.GameObject;
import platformer.core.model.Positionable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class DefaultCamera extends OrthographicCamera implements Camera {
	Positionable target;
	int X_THRESHOLD = 100;
	int Y_THRESHOLD = 150;
	Vector3 oldTargetPos;
	
	@Override
	public void setToOrtho(boolean yDown, float viewportWidth,
			float viewportHeight) {
		super.setToOrtho(yDown, viewportWidth, viewportHeight);
		X_THRESHOLD = (int) (this.viewportWidth * 0.05);
		Y_THRESHOLD = (int) (this.viewportHeight * 0.1);
	}
	
	@Override
	public void update() {		
		followTarget();
				
		super.update();
	}

	private void followTarget() {
		if (target != null) {
			Vector3 targetPos = target.getPosition();
			
			int diffX = (int) (targetPos.x - position.x);
			int diffY = (int) (targetPos.y - position.y);
			
			float deltaX = targetPos.x - oldTargetPos.x;
			float deltaY = targetPos.y - oldTargetPos.y;
			
			if ( Math.abs(diffX) > X_THRESHOLD ) {
				this.translate(deltaX, 0);
			}

			if ( Math.abs(diffY) > Y_THRESHOLD ) {
				this.translate(0, deltaY);
			}
							
			oldTargetPos = new Vector3(targetPos);
		}
	}

	@Override
	public void setTarget(Positionable t) {
		target = t;
		oldTargetPos = target.getPosition();
		position.x = oldTargetPos.x;
		position.y = oldTargetPos.y;
	}

}
