/**
 * 
 */
package me.learn.personal.month6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Title 1658 :
 * 
 * Date : Jan 14, 2021
 * 
 * @author bramanarayan
 *
 */
public class MinimumOperationsToMakeTargetZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MinimumOperationsToMakeTargetZero solution = new MinimumOperationsToMakeTargetZero();
		// System.out.println(solution.minOperations(new int[] { 1, 1, 4, 2, 3 }, 5));
		System.out.println(solution.minOperations(new int[] { 3, 2, 20, 1, 1, 3 }, 10));

	}

	// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/discuss/935935/Java-Detailed-Explanation-O(N)-Prefix-SumMap-Longest-Target-Sub-Array

	// 2 sum and hashmap based solution.
	// This is a beautiful algorithm.

	// Translates to find the longest subarray matching target

	int target = 0;

	public int minOperations(int[] nums, int x) {
		
		target = Arrays.stream(nums).sum() - x;

		int result = 0;
		// find the longest subarray now
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - target)) {
				result = Math.max(result, i - map.get(sum - target) + 1);
			}
			map.put(sum, i);
		}

		return result == 0 ? -1 : nums.length - result;

	}
}
