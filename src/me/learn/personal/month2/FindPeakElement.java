/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title  162 : 
 * 
 * A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.

 *  
 * 
 * @author bramanarayan
 * @date Jun 9, 2020
 */
public class FindPeakElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindPeakElement solution = new FindPeakElement();
		System.out.println(solution.findPeakElement(new int[] {1,2,1,3,5,6,4}));
	}

	/**
	 * if m-1 > m // search left
	 * if m+1 > m // then search right. proof is tricky. take some examples.
	 *
	 *O(log n)
	 */
	public int findPeakElement(int[] nums) {
		int l = 0;
		int h = nums.length - 1;
		
		if(nums.length == 1) return 0;

		while (l <= h) {
			int m = l + ((h - l) / 2);
			
			// take care if m is first element or m is at last elemtn
			if ( (m ==  0 || nums[m] >= nums[m - 1]) && (m == nums.length-1 || nums[m] >= nums[m + 1])) {
				return m;
			} else if (m > 0 && nums[m - 1] > nums[m]) {
				h = m - 1;
			} else {
				l = m + 1;
			}
		}
		return -1;

	}

}
