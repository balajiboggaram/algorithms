/**
 * 
 */
package me.learn.personal.month5;

import java.util.HashSet;
import java.util.Set;

/**
 * Title 128 :
 * 
 * Date : Jan 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class LongestConsecutiveSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
		System.out.println(solution.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
	}

	public int longestConsecutive(int[] nums) {

		int n = nums.length;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			set.add(nums[i]);
		}

		int result = 0;
		for (Integer x : set) {
			int count = 0;
			// only process if its first element of series
			if (!set.contains(x - 1)) {
				while (set.contains(x)) {
					//System.out.println(x);
					count++;
					if (set.contains(x + 1)) {
						x = x + 1;
					} else {
						break;
					}
				}
				result = Math.max(count, result);
			}
		}
		return result;

	}

}
