/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 713 :  
 * 
 * Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays
 where the product of all the elements in the subarray is less than k.

Example 1:

Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

Note:
0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.
 * 
 * @author bramanarayan
 * @date Jun 11, 2020
 */
public class SubArrayProductLessThanK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SubArrayProductLessThanK solution = new SubArrayProductLessThanK();
		System.out.println(solution.numSubarrayProductLessThanK(new int[] {10,5,2,6}, 100));
		System.out.println(solution.numSubarrayProductLessThanK(new int[] {1,2,3,4}, 10));
		System.out.println(solution.numSubarrayProductLessThanK(new int[] {5,3,2}, 16));

	}
	
	/**
	 * SLIDING WINDOW TECHNIQUE
	 */
	public int numSubarrayProductLessThanK(int[] a, int k) {
		int n = a.length;
		int start = 0;
		int end = 0;

		int count = 0, product = 1;
		while (end < n) {

			product = product * a[end];

			if (product >= k) {
				
				// adjust start(left pointer) as the product is greater than what we end.
				while (product >= k && start < end) {
					product = product / a[start];
					start++;
				}
			}

			
	        // If p is less than k, update the counter. 
	        // Note that this is working even for  
	        // (start == end): it means that the  
	        // previous window cannot grow anymore  
	        // and a single array element is the only 
	        // addendum. 
			if (product < k) {
				count += (end - start) + 1;
			}
			end++;
		}
		return count;

	}

}
