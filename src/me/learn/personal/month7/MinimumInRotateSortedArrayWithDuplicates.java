/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title 154 :
 * 
 * Date : Mar 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class MinimumInRotateSortedArrayWithDuplicates {

	public int findMin(int[] nums) {
		// clarification: nums == null ??

		int lo = 0, hi = nums.length - 1;

		if (nums[lo] < nums[hi])
			return nums[lo];

		while (lo < hi) {
			
			int mid = lo + (hi - lo) / 2;

			if (nums[mid] > nums[hi]) {
				lo = mid + 1; // right is unsorted
			} else if (nums[mid] < nums[hi]) {
				hi = mid; // right is sorted
			} else {
				hi--;
			}
		}

		return nums[hi];
	}
}
