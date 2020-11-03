/**
 * 
 */
package me.learn.personal.month3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title 659 :
 * 
 * Given an array nums sorted in ascending order, return true if and only if you
 * can split it into 1 or more subsequences such that each subsequence consists
 * of consecutive integers and has length at least 3.
 * 

 * Example 1:
 * 
 * Input: [1,2,3,3,4,5] Output: True Explanation: You can split them into two
 * consecutive subsequences : 1, 2, 3 3, 4, 5
 * 
 * @author bramanarayan
 * @date Jul 19, 2020
 */
public class SplitArrayInto2ConsecutiveSubSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// OTHERS - skipped. Google
	public boolean isPossible(int[] nums) {

		Integer prev = null;

		int prevCount = 0;
		Queue<Integer> starts = new LinkedList();
		int anchor = 0;
		for (int i = 0; i < nums.length; ++i) {
			int t = nums[i];
			if (i == nums.length - 1 || nums[i + 1] != t) {
				int count = i - anchor + 1;
				if (prev != null && t - prev != 1) {
					while (prevCount-- > 0)
						if (prev < starts.poll() + 2)
							return false;
					prev = null;
				}

				if (prev == null || t - prev == 1) {
					while (prevCount > count) {
						prevCount--;
						if (t - 1 < starts.poll() + 2)
							return false;
					}
					while (prevCount++ < count)
						starts.add(t);
				}
				prev = t;
				prevCount = count;
				anchor = i + 1;
			}
		}

		while (prevCount-- > 0)
			if (nums[nums.length - 1] < starts.poll() + 2)
				return false;
		return true;
	}
}
