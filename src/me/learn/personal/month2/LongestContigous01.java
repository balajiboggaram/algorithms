/**
 * 
 */
package me.learn.personal.month2;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 525 å: Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:

Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:

Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Note: The length of the given binary array will not exceed 50,000. 

 * 
 * @author bramanarayan
 * @date May 26, 2020
 */
public class LongestContigous01 {

	public static void main(String[] args) {
		
		LongestContigous01 solution = new LongestContigous01();
		System.out.println(solution.findMaxLength(new int[] {1,0,1,1,1,0,0}));
		System.out.println(solution.findMaxLength(new int[] {0,1}));
		System.out.println(solution.findMaxLength(new int[] {0,1,0}));

	}

	public int findMaxLength(int[] a) {
		
		int n = a.length, curSum = 0;
		
		if(n < 2) return 0;
		
		// Transform 0 to -1 and Compute the left sum
		int[] lSum = new int[n]; // left sum
		for (int i = 0; i < n; i++) {
			if (a[i] == 0)
				a[i] = -1;
			curSum += a[i];
			lSum[i] = curSum;
		}
		
		// Lets compute the maxLength
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int maxLength = 0;
		for(int i = 0;i<n;i++) {
			if(lSum[i] == 0 ) {
				maxLength = Math.max(maxLength, i + 1);
			} else if (map.containsKey(lSum[i])) { 
				maxLength = Math.max(maxLength, i-map.get(lSum[i]));
			} else {
				map.put(lSum[i], i);
			}
		}
		return maxLength;
	}

}
