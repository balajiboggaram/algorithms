/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 258 :
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class AddDigits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int addDigits(int n) {
		int res = 0;
		if (n < 10)
			return n;
		while (n > 9) {
			res += n % 10;
			n = n / 10;
		}
		res += n; // you need to add the last remainder piece 0 to 9 if any present
		return res < 10 ? res : addDigits(res);

	}

	// We can solve this crap in O(1) time, here is the trick for it
	public int addDigitsConstantTime(int num) {
		
		if (num == 0)
			return 0;
		
		if (num % 9 == 0)
			return 9;
		
		return num % 9;
	}

}
