package me.learn.personal.month1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Title 229 : Given an integer array of size n, find all elements that appear
 * more than ⌊ n/3 ⌋ times.
 * 
 * Note: The algorithm should run in linear time and in O(1) space.
 * 
 * @author bramanarayan
 * @date May 17, 2020
 */
public class MajorityElement2 {

	public static void main(String args[]) {
		MajorityElement2 solution = new MajorityElement2();
		// System.out.println(solution.majorityElement(new int[] { 3, 2, 3 }));
		System.out.println(solution.majorityElement(new int[] { 1, 1, 1, 3, 3, 2, 2, 2 }));
	}

	/**
	 * pick two candidates, and decide if they are really candidate > n/3
	 * 
	 * There can be atmost 2 candidates since its n/3 problem.
	 * 
	 * Think like as if its election, people keep getting votes as you see the
	 * numbers but you have memory to keep only two good candidates - i.w winner and
	 * runner.
	 * 
	 */
	public List<Integer> majorityElement(int[] nums) {

		int count1 = 0, count2 = 0;
		int n = nums.length;
		int first = Integer.MIN_VALUE, second = Integer.MAX_VALUE;
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (first == nums[i]) {
				count1++;
			} else if (second == nums[i]) {
				count2++;
			} else if (count1 == 0) {
				// need to pick my first winner here
				first = nums[i];
				count1++; // he just got one vote here
			} else if (count2 == 0) {
				// need to pick my second winner or aka runner here
				second = nums[i];
				count2++;
			} else {
				// its neither my picked winner or runner, so both lost a vote to others
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;
		// Again now - traverse the array
		for (int i = 0; i < n; i++) {
			if (nums[i] == first)
				count1++;

			else if (nums[i] == second)
				count2++;
		}
		if (count1 > n / 3 && count2 > n / 3) {
			result.add(first);
			result.add(second);
		} else if (count1 > n / 3) {
			result.add(first);
		} else if (count2 > n / 3) {
			result.add(second);
		}
		return result;
	}

}
