package me.learn.personal.month1;

/**
 * 
 * Title 152 : Given an integer array nums, find the contiguous subarray within
 * an array (containing at least one number) which has the largest product.
 * 
 * @author bramanarayan
 * @date May 16, 2020
 */
public class MaxProductSubArray {

	public static void main(String args[]) {
		MaxProductSubArray solution = new MaxProductSubArray();
		System.out.println(solution.maxProduct(new int[] { 2, 3, -2, 4 }));
		System.out.println(solution.maxProduct(new int[] { 2, 3, 4, -5, -6 }));
		System.out.println(solution.maxProduct(new int[] { -2, 0, -1 }));

	}

	public int maxProduct(int[] nums) {
		if (nums.length == 0)
			return 0;

		int curMax = nums[0];
		int curMin = nums[0];
		int finalMax = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int temp = curMax;
			// here the max can be obatined by : 
			// 1. by multiplying the number with curMax or cur Min (neg * neg = positive) ornumber itself
			curMax = Math.max(Math.max(curMax * nums[i], curMin * nums[i]), nums[i]);

			// The minimum is obatined bymultiplying the number with curmax (temp) or curMin
			// or number itself.
			curMin = Math.min(Math.min(temp * nums[i], curMin * nums[i]), nums[i]);

			if (finalMax < curMax) {
				finalMax = curMax;
			}
		}
		return finalMax;
	}
}
