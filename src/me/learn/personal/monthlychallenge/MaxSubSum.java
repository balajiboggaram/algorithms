package me.learn.personal.monthlychallenge;

/**
 * 
 * Title : Given an integer array nums, find the contiguous subarray (containing
 * at least one number) which has the largest sum and return its sum.
 * 
 * This is solved using Kadane Algorithm
 * 
 * @author bramanarayan
 * @date Apr 29, 2020
 */
public class MaxSubSum {

	public static void main(String args[]) {
		
		MaxSubSum solution = new MaxSubSum();
		solution.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
	}

	public int maxSubArray(int[] nums) {
		int maxsum = Integer.MIN_VALUE;
		int sum = 0, start = 0, end = 0;
		for (int i = 0; i < nums.length; i++) {

			sum += nums[i];
			if (sum > maxsum) {
				maxsum = sum;
				end = i;
			}

			if (sum <= 0) {
				sum = 0;
				start = i + 1;
			}
		}
		System.out.println("The max sum is : " + maxsum);
		return maxsum;
	}
}
