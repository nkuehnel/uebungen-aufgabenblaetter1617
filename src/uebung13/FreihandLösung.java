package uebung13;

import java.util.Arrays;
import java.util.List;

public class FreihandLösung {

	public static void main(String[] args) {
		List<Double> myNumbers = Arrays.asList(2.3, 5.0, 1.2, -3.4, Math.PI, 0.0);
		System.out.println("Der Durchschnitt meiner Zahlen ist: " + mean(myNumbers));

	}

	private static double mean(List<Double> myNumbers) {
		double sum = 0;
		for(Double dbl: myNumbers) {
			sum+= dbl;
		}
		return sum / myNumbers.size();
	}

}
