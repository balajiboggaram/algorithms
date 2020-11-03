package me.learn.personal.month1;

import java.util.Arrays;

/**
 * 
 * Title 16 : 3Sum Closest
 * 
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * @author bramanarayan
 * @date May 17, 2020
 */
public class ThreeSumClosest {

	public static void main(String args[]) {
		ThreeSumClosest solution = new ThreeSumClosest();
		System.out.println(solution.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
		System.out.println(solution.threeSumClosest(new int[] { 0, 0, 0 }, 1));

	}

	/**
	 * Time complexity is O(n2). Similar to : 3sum - Find three numbers with target
	 * 3sum zero - Find three numbers with target zero
	 */
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		if (nums.length < 3)
			return -1;
		int n = nums.length;
		int result = 0;
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) {
			int l = i + 1;
			int h = n - 1;
			while (l < h) {
				int value = nums[i] + nums[l] + nums[h];
				if (value == target)
					return target;
				if (value > target) {
					h--;
				} else {
					l++;
				}
				if (Math.abs(value - target) < Math.abs(diff)) {
					result = value;
					diff = value - target;
				}
			}
		}
		return result;
	}

}
