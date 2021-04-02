/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 172 :
 * 
 * Date : Jan 8, 2021
 * 
 * @author bramanarayan
 *
 */
public class TrailingZerosInFactorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TrailingZerosInFactorial solution = new TrailingZerosInFactorial();
		System.out.println(solution.trailingZeros(10));
	}

	// total number of trailing zeros is equal to how many times you will be able to
	// divide the given integer by 5
	int trailingZeros(int n) {
		
		int count = 0;
		while(n != 0) {
			count = count + n/5;
			n = n/5;
		}
		return count;
	}
}
