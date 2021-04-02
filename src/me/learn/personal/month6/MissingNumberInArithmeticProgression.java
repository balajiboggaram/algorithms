/**
 * 
 */
package me.learn.personal.month6;

/**
 * Title 1228 :
 * 
 * Date : Jan 12, 2021
 * 
 * @author bramanarayan
 *
 */
public class MissingNumberInArithmeticProgression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// trick is (last - first)/n
	public int missingNumber(int[] a) {
		int n = a.length;
		int d = (a[n - 1] - a[0]) / a.length;

		if (d == 0 && a[0] == 0)
			return 0;

		if (d == 0 && a[0] != 0)
			return a[0];
		int prev = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] != prev + d) {
				return prev + d;
			}
			prev = a[i];
		}
		return 0;
	}

}
