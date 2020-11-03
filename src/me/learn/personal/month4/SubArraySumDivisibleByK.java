/**
 * 
 */
package me.learn.personal.month4;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 974 :
 * 
 * Given an array A of integers, return the number of (contiguous, non-empty)
 * subarrays that have a sum divisible by K.
 * 
 *
 * Example 1:
 * 
 * Input: A = [4,5,0,-2,-3,1], K = 5 Output: 7 Explanation: There are 7
 * subarrays with a sum divisible by K = 5: [4, 5, 0, -2, -3, 1], [5], [5, 0],
 * [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * 
 * 
 * @author bramanarayan
 * @date Aug 20, 2020
 */
public class SubArraySumDivisibleByK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SubArraySumDivisibleByK solution = new SubArraySumDivisibleByK();
		System.out.println(solution.subarraysDivByK(new int[] {4,5,0,-2,-3,1}, 5));
	}

	// Repeat
	// compute the a[i] %k and keep inserting in to a map
	// if the mod value is already present, then we have a subarray until that index
	// which divides by k. thus add to count
	public int subarraysDivByK(int[] a, int k) {
		int count = 0;
		int preSum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		
		for (int i = 0; i < a.length; i++) {
			preSum = (preSum + a[i]) %k; 
			
			if(preSum < 0) {
				// to handle any negative
				preSum = preSum + k;
			}
			
			
			if(map.containsKey(preSum)) {
				count += map.get(preSum);
			} 
			map.put(preSum, map.getOrDefault(preSum, 0)+1);
		}
		return count;

	}

}
