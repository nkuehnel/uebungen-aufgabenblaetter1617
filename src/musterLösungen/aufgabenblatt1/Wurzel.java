package musterLösungen.aufgabenblatt1;

public class Wurzel {
	
	public static void main(String[] args) {
		quadratwurzelSchaetzen(9);
	}
	
	static void quadratwurzelSchaetzen(double a) {
		
		double x0 = a / 2.;
		double x1 = (x0 + (a / x0))/2;
		
		while(Math.abs(x1 - x0) >= 0.0001) {
			x0 = x1;
			x1 = (x0 + (a / x0))/2;
			System.out.println(x1);
		}	
	}
}
