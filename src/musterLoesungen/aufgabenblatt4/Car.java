package musterLoesungen.aufgabenblatt4;

import gridworld.framework.actor.Actor;
import gridworld.framework.grid.Location;

public class Car extends Actor {

	private int speed = 5;

	public Car() {
		this.setDirection(Location.EAST);
	}

	@Override
	public void act() {
		accelerate();
		dawdle();
		brakeIfNeeded();
		Location target = getTargetLocation();
		if (this.getGrid().isValid(target)) {
			super.moveTo(target);
		} else {
			this.removeSelfFromGrid();
		}
	}

	private void brakeIfNeeded() {
		for (int n = 1; n <= speed; n++) {
			Location nthLocationAhead = new Location(this.getLocation().getRow(), this.getLocation().getCol() + n);
			if (this.getGrid().isValid(nthLocationAhead)) {
				Actor occupant = this.getGrid().get(nthLocationAhead);
				if (occupant != null) {
					this.speed = n - 1;
				}
			}
		}

	}

	private Location getTargetLocation() {
		return new Location(this.getLocation().getRow(), this.getLocation().getCol() + speed);
	}

	private void accelerate() {
		if (speed < 5) {
			this.speed++;
		}
	}

	private void dawdle() {
		if (Math.random() < 0.2) {
			this.speed--;
		}
	}

}
