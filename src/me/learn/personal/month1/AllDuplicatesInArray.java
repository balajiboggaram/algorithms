package me.learn.personal.month1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Title 442 :Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 * 
 * Find all the elements that appear twice in this array.
 * 
 * Could you do it without extra space and in O(n) runtime?
 * 
 * @author bramanarayan
 * @date May 20, 2020
 */
public class AllDuplicatesInArray {

	public static void main(String args[]) {
		AllDuplicatesInArray solution = new AllDuplicatesInArray();
		System.out.println(solution.findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));

	}

	/**
	 * This solution is almost same as - Find the disappeared numbers in an array
	 */
	public List<Integer> findDuplicates(int[] nums) {

		Set<Integer> result = new HashSet<Integer>();

		if (nums.length == 0)
			return new ArrayList<>(result);
		int n = nums.length;
		nums[nums[0] - 1] = -1 * nums[nums[0] - 1];
		for (int i = 1; i < n; i++) {

			int temp = Math.abs(nums[i]);
			if (nums[temp - 1] < 0)
				result.add(Math.abs(nums[i]));
			if (nums[temp - 1] > 0) {
				nums[temp - 1] = -1 * nums[temp - 1];
			}
		}

		return new ArrayList<>(result);
	}

}
