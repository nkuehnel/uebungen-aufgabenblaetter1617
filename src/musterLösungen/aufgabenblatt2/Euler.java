package musterLösungen.aufgabenblatt2;

public class Euler {

	public static double myExp(int x, int n) {
		double result = 1;
		for (int ii = 1; ii <= n; ii++) {
			result += (Math.pow(x, ii) / fakultaet(ii));
		}
		return result;
	}

	public static double myExpFast(int x, int n) {
		long zähler = 1;
		long nenner = 1;
		double result = 1;

		for (int i = 1; i <= n; i++) {
			zähler *= x;
			nenner *= i;
			result += (double) zähler / (double) nenner;
		}

		return result;
	}

	static long fakultaet(int i) {
		long fakultaet = 1;
		for (int ii = 1; ii < i; ii++) {
			fakultaet *= (ii + 1);
		}
		return fakultaet;
	}

	public static void main(String[] args) {
		System.out.println(myExp(3, 0) + " " + myExpFast(3, 0) + " " + Math.exp(3));
	}

}
