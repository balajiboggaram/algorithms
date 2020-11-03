package me.learn.personal.month2;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Title 560 : Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2

Constraints:

    The length of the array is in range [1, 20,000].
    The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 
 * 
 * @author bramanarayan
 * @date May 26, 2020
 */
public class SubArraySumCount {

	/**
	 * If there is a sub array with k as sum, then the starting point 
	 * of the subarray i.e sum will already be in the map.
	 * 
	 * Take an example and work out. 
	 * 
	 * 3,4,7,2,-3,1,4,2
	 */
	public int subarraySum(int[] nums, int k) {

		int sum = 0, count = 0;
		int n = nums.length;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(0, 1);
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			if(map.containsKey(sum - k)) {
				count = count + map.get(sum -k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		
		return count;
	}
}
