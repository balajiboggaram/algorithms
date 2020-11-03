/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 209 :
 * 
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * Example:
 * 
 * Input: s = 7, nums = [2,3,1,2,4,3] 
 * 
 * Output: 2 Explanation: the subarray [4,3]
 * has the minimal length under the problem constraint.
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution of which the time complexity is O(n log n).
 * 
 * 
 * @author bramanarayan
 * @date Jun 13, 2020
 */
public class MinimumSizeSubarraySum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();
		//System.out.println(solution.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
		//System.out.println(solution.minSubArrayLen(11, new int[] {1,2,3,4,5}));
		System.out.println(solution.minSubArrayLen(4, new int[] {1,4,4}));

	}
	
		// TWO POINTERS SOLUTION
		public int minSubArrayLen(int s, int[] a) {
			int n = a.length;
	
			if(n ==0) return 0;
			int i = 0, j = 0, curSum = 0, minSize = Integer.MAX_VALUE;
			
			while(j < n) {
				curSum += a[j];
				if(curSum >= s) {
					while(curSum >= s && i <= j) {
						minSize = Math.min(minSize, j-i+1);
	
						curSum -= a[i];
						i++;
					}
				}
				j++;
			}
			
			return minSize == Integer.MAX_VALUE ? 0 : minSize;
		}

}
