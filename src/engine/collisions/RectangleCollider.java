package engine.collisions;

import structures.run.RunObject;

public class RectangleCollider implements ICollider {

	@Override
	public boolean collides(RunObject one, RunObject two) {
		return one.getBounds().intersects(two.getBounds());
	}

}