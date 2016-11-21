package aufgabenblatt4;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class RunCarGridWorld {

	public static void main(String[] args) {
		// create the world
		ActorWorld world = new ActorWorld();
		// define the size of the grid
        world.setGrid(new BoundedGrid<Actor>(1,37));
        // add a car at the leftmost position
        world.add(new Location(0,0), new Car());
        
        // here you may add other things to the grid
        
        // visualize the world
        world.show();
	}

}
