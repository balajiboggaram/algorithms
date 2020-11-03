/**
 * 
 */
package me.learn.personal.month4;

/**
 * Title 374 :
 * 
 * We are playing the Guess Game. The game is as follows:
 * 
 * I pick a number from 1 to n. You have to guess which number I picked.
 * 
 * Every time you guess wrong, I'll tell you whether the number is higher or
 * lower.
 * 
 * You call a pre-defined API guess(int num) which returns 3 possible results
 * (-1, 1, or 0):
 * 
 * -1 : My number is lower 1 : My number is higher 0 : Congrats! You got it!
 * 
 * Example :
 * 
 * Input: n = 10, pick = 6 Output: 6
 * 
 * 
 * @author bramanarayan
 * @date Aug 2, 2020
 */
public class GuessNumberHigherOrLower {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int guessNumber(int n) {
		int l = 0;
		int h = n;
		
		while(l <= h) {
			
			int mid = l + (h-l)/2;
			int res = guess(mid);
			if(res == 0)
				return mid;
			else if(res == -1) {
				h = mid -1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	// MOCK
	private int guess(int mid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
