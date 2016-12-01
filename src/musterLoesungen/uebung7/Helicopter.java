package musterLösungen.uebung7;

public class Helicopter implements CanMoveHorizontally, CanMoveVertically {

	private String name;
	private double x;
	private double y;
	private double z;
	private double vSpeed;
	private double hSpeed;
	private double radians = 0;

	public Helicopter(String name, double x, double y, double z) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void move() {
		this.x += Math.cos(radians) * hSpeed;
		this.y += Math.sin(radians) * hSpeed;
		this.z += this.vSpeed;
		if (this.z < 0) {
			this.z = 0;
			this.vSpeed = 0;
			this.hSpeed = 0;
			System.err.println("Helikopter " + this.name + " notgelandet");
		}
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void increaseVerticalSpeed(double by) {
		this.vSpeed += by;
	}

	@Override
	public void increaseHorizontalSpeed(double by) {
		this.hSpeed += by;
	}

	@Override
	public void turnBy(double radians) {
		this.radians += radians;
	}

	@Override
	public String toString() {
		return "Helicopter " + this.name + ", at position (" + this.x + ", " + this.y + ", " + this.z + ")";
	}

}

