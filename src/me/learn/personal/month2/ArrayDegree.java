package me.learn.personal.month2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Title 697 : 
 * 
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * 
 * 
 * In fact, this question need to consider multi items have same max frequency.
Example 1 . [1, 2, 2, 3, 1]
item 1 and item 2 both appear most frequency 2 times.
to get (contiguous) subarray contain item 1 for 2 times , we can only get
[1,2,2,3,1] length is 5
to get (contiguous) subarray contain item 2 for 2 times , we can get
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
shortest length is 2.
So, return 2
Example 2 [1,2,2,3,1,4,2]
the most frequency appearing item is 2, which appeared 3 times.
to get (contiguous) subarray contain item 2 for 3 times , we can get
[1,2,2,3,1,4,2] length is 7
[2,2,3,1,4,2] length is 6
no other solution, so, the shortest subarray length is 6

I may add one expamle to explain
[5,5,5,1,6,1,6,6]
5 and 6 are the most frequency items, both appear 3 times
to get (contiguous) subarray contain item 5 is [5,5,5]. length is 3
to get (contiguous) subarray contain item 6 is [6,1,6,6]. length is 4 
 * 
 * @author bramanarayan
 * @date May 26, 2020
 */
public class ArrayDegree {

	/**
	 * For each element in the given array, let's know left, the index of its first
	 * occurrence; and right, the index of its last occurrence. For example, with
	 * nums = [1,2,3,2,5] we have left[2] = 1 and right[2] = 3.
	 * 
	 * Then, for each element x that occurs the maximum number of times, right[x] -
	 * left[x] + 1 will be our candidate answer, and we'll take the minimum of those
	 * candidates.
	 */
	public int findShortestSubArray(int[] nums) {
		Map<Integer, Integer> left = new HashMap(), right = new HashMap(), count = new HashMap();

		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			if (left.get(x) == null)
				left.put(x, i);
			right.put(x, i);
			count.put(x, count.getOrDefault(x, 0) + 1);
		}

		int ans = nums.length;
		int degree = Collections.max(count.values());
		for (int x : count.keySet()) {
			if (count.get(x) == degree) {
				ans = Math.min(ans, right.get(x) - left.get(x) + 1);
			}
		}
		return ans;
	}

}
