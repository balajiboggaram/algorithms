package me.learn.personal.monthlychallenge.may;

/**
 * 
 * Title : Given an array of size n, find the majority element. The majority
 * element is the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * @author bramanarayan
 * @date May 6, 2020
 */
public class MajorityElement {

	public static void main(String args[]) {
		MajorityElement solution = new MajorityElement();
		solution.majorityElement(new int[] { 3, 2, 3, 2, 2, 2 });
		solution.majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 });
		solution.majorityElement(new int[] { 3, 2, 3 });
	}

	/**
	 * Moores Voting Algorithm
	 */
	public int majorityElement(int[] nums) {

		int count = 1, n = nums.length, majorityElement = nums[0];

		for (int i = 1; i < n; i++) {
			if (count > n / 2) {
				return majorityElement;
			}

			if (majorityElement == nums[i]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				majorityElement = nums[i];
				count = 1;
			}
		}
		System.out.println(majorityElement);
		return majorityElement;
	}
}
