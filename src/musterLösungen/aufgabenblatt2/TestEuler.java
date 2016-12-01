package musterLösungen.aufgabenblatt2;

import org.junit.Assert;
import org.junit.Test;

public class TestEuler {
	
	@Test
	public void testMathExpVsMyExp() {
		
		//Verschiedene x und n mit Fehlerterm 0.1
		Assert.assertEquals(Math.exp(1), Euler.myExpFast(1, 3), 0.1);
		Assert.assertEquals(Math.exp(2), Euler.myExpFast(2, 6), 0.1);
		Assert.assertEquals(Math.exp(3), Euler.myExpFast(3, 8), 0.1);
		Assert.assertEquals(Math.exp(4), Euler.myExpFast(4, 12), 0.1);
		Assert.assertEquals(Math.exp(5), Euler.myExpFast(5, 14), 0.1);
		
		for(int i = 1; ; i++) {
			double result = Euler.myExpFast(1, i);
			System.out.println(result);
			if(Math.exp(1) - result < 1E-15) {
				System.out.println("Fixiere n auf " + i);
				break;
			}
		}
	}
}
