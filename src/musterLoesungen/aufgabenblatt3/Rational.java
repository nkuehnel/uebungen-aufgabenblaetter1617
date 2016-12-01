package musterLösungen.aufgabenblatt3;

class Rational {

	private int zaehler;
	private int nenner;

	public Rational() {
		zaehler = 0;
		nenner = 1;
	}

	public Rational(int zaehler, int nenner) {
		this.zaehler = zaehler;
		this.nenner = nenner;
	}

	public static void main(String[] args) {
		Rational r = new Rational();
		r.setNenner(4);
		r.setZaehler(6);
		r.printRational();
		r.reduce();
		r.printRational();
		r.add(new Rational(3, 8));
		r.printRational();
		r.invert();
		r.printRational();
	}

	private void printRational() {
		System.out.println(zaehler + "/" + nenner);
	}

	private void setNenner(int nenner) {
		this.nenner = nenner;
	}

	private void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}

	private void negate() {
		this.zaehler *= -1;
	}

	private void invert() {
		int temp = this.nenner;
		this.nenner = this.zaehler;
		this.zaehler = temp;

	}

	private double toDouble() {
		return (double) zaehler / nenner;
	}

	private void reduce() {
		int ggT = ggt(zaehler, nenner);
		this.zaehler /= ggT;
		this.nenner /= ggT;
	}

	private int ggt(int a, int b) {
		if (b == 0) {
			return a;
		} else if (a == 0) {
			return b;
		} else if (a > b) {
			return ggt(a - b, b);
		} else {
			return ggt(a, b - a);
		}
	}

	private void add(Rational r) {
		this.zaehler = this.zaehler * r.nenner + (r.zaehler * this.nenner);
		this.nenner *= r.nenner;
	}
}
