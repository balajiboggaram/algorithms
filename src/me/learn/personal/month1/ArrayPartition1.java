package me.learn.personal.month1;

import java.util.Arrays;

/**
 * 
 * Title 561 : Given an array of 2n integers, your task is to group these
 * integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which
 * makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * 
 * @author bramanarayan
 * @date May 17, 2020
 */
public class ArrayPartition1 {

	public static void main(String args[]) {
		ArrayPartition1 solution = new ArrayPartition1();
		System.out.println(solution.arrayPairSum(new int[] { 1, 4, 3, 2 }));
	}

	/**
	 * Sort the array and then get the minimum. 
	 * No need to take care of odd since there are 2n elements.
	 */
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length; // O(1) operation due to array metadata
		int result = 0;
		if (n == 0)
			return 0;
		for (int i = 1; i < n; i+=2) {
			result += Math.min(nums[i], nums[i -1 ]);
		}
		return result;
	}
}
