package me.learn.personal.month1;

/**
 * 
 * Title 268 : Given an array containing n distinct numbers taken from 0, 1, 2,
 * ..., n, find the one that is missing from the array.
 * 
 * @author bramanarayan
 * @date May 20, 2020
 */
public class MissingNumber {

	public static void main(String args[]) {

		MissingNumber solution = new MissingNumber();
		System.out.println(solution.missingNumber(new int[] { 3, 0, 1 }));
		System.out.println(solution.missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));

	}

	public int missingNumber(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		if (n == 1 && nums[0] == 1)
			return 0;

		int totalSum = (n * (n + 1)) / 2;
		int inputSum = 0;

		for (int i = 0; i < n; i++) {
			inputSum += nums[i];
		}

		return totalSum - inputSum;

	}
}
