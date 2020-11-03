package me.learn.personal.month1;

/**
 * 
 * Title 41 : Given an unsorted integer array, find the smallest missing
 * positive integer.
 * 
 * Revision
 * 
 * @author bramanarayan
 * @date May 20, 2020
 */
public class FirstMissingPositive {

	public static void main(String[] args) {
		FirstMissingPositive solution = new FirstMissingPositive();
		System.out.println(solution.firstMissingPositive(new int[] {7,8,9,11,12}));
	}

	public int firstMissingPositive(int[] nums) {

		int n = nums.length;
		// check if 1 is present, if not we found the answer
		boolean oneFound = false;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				oneFound = true;
				break;
			}
		}
		if (!oneFound)
			return 1;

		if (n == 1) // simple optimization
			return 2;

		// Clean up the data. Replace all the -v2s, >n and 0s with 1.
		for (int i = 0; i < n; i++) {
			if (nums[i] <= 0 || nums[i] > n) {
				nums[i] = 1;
			}
		}

		// Use index as a hash key and number sign as a presence detector.
		// For example, if nums[1] is negative that means that number `1`
		// is present in the array.
		// If nums[2] is positive - number 2 is missing.
		for (int i = 0; i < n; i++) {

			int a = Math.abs(nums[i]);
			if (a == n)
				nums[0] = -Math.abs(nums[0]); // turn this as negative if n is present in array
			else
				nums[a] = -Math.abs(nums[a]);
		}

		// Find the index of first positive. This is index
		for (int i = 1; i < n; i++) {
			if (nums[i] > 0) {
				return i;
			}
		}

		if (nums[0] > 0)
			return n;

		return n + 1;
	}

}
