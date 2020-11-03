package me.learn.personal.month2;

/**
 * 
 * Title 33 : Suppose an array sorted in ascending order is rotated at some
 * pivot unknown to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * @author bramanarayan
 * @date May 23, 2020
 */
public class SearchRotatedSortedArray {

	public static void main(String args[]) {
		SearchRotatedSortedArray solution = new SearchRotatedSortedArray();
		System.out.println(solution.search(new int[] { 4, 5, 6, 7, 8, 9, 1, 2, 3 }, 6));
		System.out.println(solution.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
		System.out.println(solution.search(new int[] { 3,1 }, 1));

	}

	/**
	 * Check the target(mid element) with both the bounds of sorted array.
	 */
	public int search(int[] nums, int target) {
		int n = nums.length;
		int l = 0, h = n-1, mid;

		while (l <= h) {
			mid = l + ((h - l) / 2);
			if (nums[mid] == target) {
				return mid;
			} else if (nums[l] <= nums[mid]) {
				// left array is sorted
				if (nums[mid] >= target && target >= nums[l]) {
					h = mid - 1;
				} else {
					l = mid + 1;
				}
			} else {
				// right array is sorted
				if (nums[mid] <= target && target <= nums[h]) {
					l = mid + 1;
				} else {
					h = mid - 1;
				}
			}
		}
		return -1;
	}
}
