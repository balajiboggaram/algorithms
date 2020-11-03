package me.learn.personal.month1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Title 448 : Given an array of integers where 1 ≤ a[i] ≤ n (n = size of
 * array), some elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 * 
 * @author bramanarayan
 * @date May 20, 2020
 */
public class DisappearedNumbersArray {

	public static void main(String args[]) {
		DisappearedNumbersArray solution = new DisappearedNumbersArray();
		System.out.println(solution.findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
	}

	/**
	 * As you traverse the array, Keep marking the position of the array element as
	 * negative. Make sure, you take the abs(value) to ignore negative on already
	 * marked element.
	 * 
	 * at last, all we care are the indicies of elements which are positive.
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();

		if (nums.length == 0)
			return result;
		int n = nums.length;
		nums[nums[0] - 1] = -1 * nums[nums[0] - 1];
		for (int i = 1; i < n; i++) {
			int temp = Math.abs(nums[i]);
			if (nums[temp - 1] > 0) {
				nums[temp - 1] = -1 * nums[temp - 1];
			}
		}

		for (int i = 0; i < n; i++) {
			if (nums[i] > 0) {
				result.add(i + 1);
			}
		}

		return result;

	}
}
