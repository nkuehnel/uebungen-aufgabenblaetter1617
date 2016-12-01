package musterLösungen.uebung7;

public class Ship implements CanMoveHorizontally {

	private String name;
	private double x;
	private double y;
	private double speed;
	private double radians = 0;

	public Ship(String name, double x, double y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	@Override
	public void move() {
		this.x += Math.cos(radians) * this.speed;
		this.y += Math.sin(radians) * this.speed;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void increaseHorizontalSpeed(double by) {
		this.speed += by;
	}

	@Override
	public void turnBy(double radians) {
		this.radians += radians;
	}

	@Override
	public String toString() {
		return "Ship " + this.name + ", at position (" + this.x + ", " + this.y + ")";
	}

}


