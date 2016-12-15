package musterLoesungen.aufgabenblatt4;

import gridworld.framework.actor.Actor;
import gridworld.framework.actor.ActorWorld;
import gridworld.framework.grid.BoundedGrid;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

public class Main {

	public static void main(String[] args) {
		Grid<Actor> grid = new BoundedGrid<Actor>(10, 50);
		ActorWorld world = new ActorWorld(grid);
		for (int i = 0; i < 10; i++) {
			Location loc = new Location(i, 0);
			world.add(loc, new CarSource(0.1 * i));
		}
		world.show();

	}

}
