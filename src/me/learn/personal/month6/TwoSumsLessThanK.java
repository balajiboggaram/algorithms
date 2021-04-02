/**
 * 
 */
package me.learn.personal.month6;

import java.util.TreeSet;

/**
 * Title 1099 :
 * 
 * Date : Jan 12, 2021
 * 
 * @author bramanarayan
 *
 */
public class TwoSumsLessThanK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Given an array nums of integers and integer k, return the maximum sum such
	 * that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j
	 * exist satisfying this equation, return -1.
	 */

	public int twoSumLessThanK(int[] nums, int K) {
		TreeSet<Integer> set = new TreeSet<>();
		int res = -1;

		for (int i = 0; i < nums.length; i++) {

			// K is my required sum.
			Integer pre = set.lower(K - nums[i]); // one of candidate

			if (pre != null) {
				res = Math.max(res, nums[i] + pre);
			}

			set.add(nums[i]);
		}

		return res;
	}
}
