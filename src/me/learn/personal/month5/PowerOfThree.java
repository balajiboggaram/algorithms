/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 326 :
 * 
 * Date : Jan 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class PowerOfThree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPowerOfThree(int n) {

		if (n < 0)
			return false;
		if (n == 1)
			return true;

		if (n >= 0 && n < 3)
			return false;

		while (n > 1) {
			if (n % 3 != 0)
				return false;
			n = n / 3;
		}
		return true;
	}

	// BEST
	public static boolean isPowerOfThreeBEST(int n) {
		if (n <= 0)
			return false;
		double r = Math.log10(n) / Math.log10(3);
		if (r % 1 == 0)
			return true;
		else
			return false;
	}

}
