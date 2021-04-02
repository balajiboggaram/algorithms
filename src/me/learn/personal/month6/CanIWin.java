/**
 * 
 */
package me.learn.personal.month6;

/**
 * Title 464 :
 * 
 * Date : Jan 15, 2021
 * 
 * @author bramanarayan
 *
 */
public class CanIWin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	/**
	 * 
	 * idea : 
	 * 
	 * We want to see if a path exists where all the branches for the opponent
	 * results in a false. The opponent tries every single branch before he gives up
	 * and returns a false.
	 * 
	 * Memoization (see below method): At any point in the decision tree, the path ahead is solely
	 * based on the numbers chosen so far. So we can use that to memoize the
	 * results.
	 */

	
	// BRUTE FORCE

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if (desiredTotal <= maxChoosableInteger)
			return true;
		if (((1 + maxChoosableInteger) / 2 * maxChoosableInteger) < desiredTotal) {
			return false;
		}
		return canIWinFrom(maxChoosableInteger, desiredTotal, new boolean[maxChoosableInteger + 1]);
	}

	private boolean canIWinFrom(int maxChoosableInteger, int desiredTotal, boolean[] chosen) {
		if (desiredTotal <= 0) {
			return false;
		}

		for (int i = 1; i <= maxChoosableInteger; i++) {
			if (chosen[i]) {
				continue;
			}
			chosen[i] = true;
			if (!canIWinFrom(maxChoosableInteger, desiredTotal - i, chosen)) {
				chosen[i] = false;
				return true;
			}
			chosen[i] = false;
		}
		return false;
	}

}
