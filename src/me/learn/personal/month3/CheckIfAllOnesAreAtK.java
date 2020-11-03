/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 1437 :
 * 
 * Given an array nums of 0s and 1s and an integer k, return True if all 1's are
 * at least k places away from each other, otherwise return False.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,0,0,0,1,0,0,1], k = 2 Output: true Explanation: Each of the
 * 1s are at least 2 places away from each other.
 * 
 * 
 * @author bramanarayan
 * @date Jun 23, 2020
 */
public class CheckIfAllOnesAreAtK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CheckIfAllOnesAreAtK solution = new CheckIfAllOnesAreAtK();
		//System.out.println(solution.kLengthApart(new int[] { 1, 0, 0, 0, 1, 0, 0, 1 }, 2));
		//System.out.println(solution.kLengthApart(new int[] { 1, 0, 0, 1, 0, 1 }, 2));
		System.out.println(solution.kLengthApart(new int[] { 1, 0, 1 }, 2));

	}

	public boolean kLengthApart(int[] a, int k) {
		int prevOne = -1;
		int n = a.length;
		for (int i = 0; i < n; i++) {

			if (a[i] == 1) {

				if (prevOne >= 0 && (i - prevOne <= k)) {
					return false;
				}
										
				prevOne = i;
			}

		}
		return true;
	}

}
