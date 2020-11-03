package me.learn.personal.month2;

/**
 * 
 * Title 167 : Given an array of integers that is already sorted in ascending
 * order, find two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2.
 * 
 * Note:
 * 
 * Your returned answers (both index1 and index2) are not zero-based. You may
 * assume that each input would have exactly one solution and you may not use
 * the same element twice.
 * 
 * 
 * @author bramanarayan
 * @date May 24, 2020
 */
public class TwoSumTwo {

	public static void main(String args[]) {
		TwoSumTwo solution = new TwoSumTwo();
		System.out.println(solution.twoSum(new int[] { 2, 7, 11, 15 }, 9));
	}

	/**
	 * Two pointers
	 */
	public int[] twoSum(int[] numbers, int target) {
		int n = numbers.length, i = 0;
		int j = n - 1;
		int[] res = new int[2];
		while (i < j) {
			if (numbers[i] + numbers[j] == target) {
				res[0] = i + 1;
				res[1] = j + 1;
				return res;
			} else if (numbers[i] + numbers[j] > target) {
				j--;
			} else {
				i++;
			}
		}
		return res;
	}
}
