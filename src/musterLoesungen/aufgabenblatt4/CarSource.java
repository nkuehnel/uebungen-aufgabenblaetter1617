package musterLoesungen.aufgabenblatt4;

import gridworld.framework.actor.Actor;
import gridworld.framework.grid.Location;

public class CarSource extends Actor {
	
	private double probability;
	
	public CarSource( double probability) {
		this.probability = probability;
		
	}
	
	@Override
	public void act() {
		Location insertLocation = new Location(this.getLocation().getRow(), this.getLocation().getCol()+1);
		if(this.getGrid().get(insertLocation) == null && Math.random() < this.probability) {
			Car car = new Car();
			car.putSelfInGrid(getGrid(), insertLocation);
		}
	}

}
