package musterLösungen.uebung7;

public class Elevator implements CanMoveVertically {

	private String name;
	private double z;
	private double speed;

	public Elevator(String name, double z) {
		this.name = name;
		this.z = z;
	}

	@Override
	public void move() {
		this.z += this.speed;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void increaseVerticalSpeed(double by) {
		this.speed += by;
	}

	@Override
	public String toString() {
		return "Elevator " + this.name + ", at position " + z;
	}

}



