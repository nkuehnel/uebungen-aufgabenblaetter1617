package musterLoesungen.aufgabenblatt4;

import gridworld.framework.actor.Actor;
import gridworld.framework.grid.Location;

public class CarSource extends Actor {
	
	private double probability;
	
	public CarSource( double probability) {
		this.probability = probability;
		this.setDirection(Location.EAST);
	}
	
	@Override
	public void act() {
		Location insertLocation = this.getLocation().getAdjacentLocation(getDirection());
		if(this.getGrid().get(insertLocation) == null && Math.random() < this.probability) {
			Car car = new Car();
			car.putSelfInGrid(getGrid(), insertLocation);
		}
	}

}
