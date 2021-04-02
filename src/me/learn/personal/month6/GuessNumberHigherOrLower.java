/**
 * 
 */
package me.learn.personal.month6;

/**
 * Title 374 :
 * 
 * Date : Jan 15, 2021
 * 
 * @author bramanarayan
 *
 */
public class GuessNumberHigherOrLower {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/***
	 * 
	 * 
	 * We are playing the Guess Game. The game is as follows:
	 * 
	 * I pick a number from 1 to n. You have to guess which number I picked.
	 * 
	 * Every time you guess wrong, I will tell you whether the number I picked is
	 * higher or lower than your guess.
	 * 
	 * You call a pre-defined API int guess(int num), which returns 3 possible
	 * results:
	 * 
	 * -1: The number I picked is lower than your guess (i.e. pick < num). 1: The
	 * number I picked is higher than your guess (i.e. pick > num). 0: The number I
	 * picked is equal to your guess (i.e. pick == num).
	 * 
	 * Return the number that I picked.
	 * 
	 * 
	 */

	// pure binary search
	public int guessNumber(int n) {

		if (n == 1)
			return 1;
		int high = n;
		int low = 1;
		while (low < high) {
			int mid = low + (high - low) / 2;

			if (guessNumber(mid) == 0) {
				return mid;
			} else if (guessNumber(mid) < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return low;

	}

}
