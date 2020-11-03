/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 665 :
 * 
 * Given an array nums with n integers, your task is to check if it could become
 * non-decreasing by modifying at most 1 element.
 * 
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for
 * every i (0-based) such that (0 <= i <= n - 2).
 * 
 * Input: nums = [4,2,3] 
 * Output: true 
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * 
 * @author bramanarayan
 * @date Jun 24, 2020
 */
public class NonDecreasingArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		NonDecreasingArray solution = new NonDecreasingArray();
		System.out.println(solution.checkPossibility(new int[] { 4, 2, 3 }));
		System.out.println(solution.checkPossibility(new int[] { 3, 4, 2, 3 }));

	}

	
	/**
	 * Keep tracking if there any inversion after you find first one.
	 */
	public boolean checkPossibility(int[] a) {

		int prev = a[0];
		int count = 0;
		for (int i = 1; i < a.length; i++) {

			// If an inversion is found
			if (a[i] < prev) {
				count++;

				// More than 1 atmost inversion, Now exit
				if (count > 1) {
					return false;
				}

				if (i - 2 >= 0 && a[i - 2] > a[i])
					continue;

			}
			prev = a[i];

		}
		return true;
	}

}
