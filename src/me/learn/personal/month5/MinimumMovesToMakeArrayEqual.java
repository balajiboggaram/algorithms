/**
 * 
 */
package me.learn.personal.month5;

import java.util.Arrays;

/**
 * Title 453 :
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class MinimumMovesToMakeArrayEqual {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// you can increment two elements in one move.

	// Basically, the idea is to sort all the elements.
	// Now, take the diff of ith element from first element and keep adding,
	// Traverse from right to left.
	public int minMoves(int[] nums) {

		Arrays.sort(nums);
		int result = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			result += (nums[i] - nums[0]);

		}
		return result;
	}

}
