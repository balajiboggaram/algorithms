package me.learn.personal.monthlychallenge;

/**
 * 
 * Title : Given a non-empty array of integers, every element appears twice
 * except for one. Find that single one.
 * 
 * @author bramanarayan
 * @date Apr 29, 2020
 */
public class SingleNumber {

	public static void main(String args[]) {
		SingleNumber solution = new SingleNumber();
		solution.singleNumber(new int[] {1, 2, 3, 4, 4, 3, 2});
		solution.singleNumber(new int[] {0});
		solution.singleNumber(new int[] {-1,-3,-3});

	}

	public int singleNumber(int[] nums) {
		int result = 0;

		for (int i = 0; i < nums.length; i++) {
			result ^= nums[i];
		}
		System.out.println("Result : " + result);
		return result;
	}

}
