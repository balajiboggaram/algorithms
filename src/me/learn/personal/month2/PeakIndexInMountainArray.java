/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 852 : 
 * 
 *  Let's call an array A a mountain if the following properties hold:

    A.length >= 3
    There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]

Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

Example 1:

Input: [0,1,0]
Output: 1

Example 2:

Input: [0,2,1,0]
Output: 1
 * 
 * @author bramanarayan
 * @date Jun 9, 2020
 */
public class PeakIndexInMountainArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	//Same solution as find the peak neigbour 
	public int peakIndexInMountainArray(int[] nums) {
		int l = 0;
		int h = nums.length - 1;

		if (nums.length == 1)
			return 0;

		while (l <= h) {
			int m = l + ((h - l) / 2);

			// take care if m is first element or m is at last elemtn
			if ((m == 0 || nums[m] >= nums[m - 1]) && (m == nums.length - 1 || nums[m] >= nums[m + 1])) {
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
