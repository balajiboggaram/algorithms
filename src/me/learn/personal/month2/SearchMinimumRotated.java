package me.learn.personal.month2;

/**
 * 
 * Title 153 : Suppose an array sorted in ascending order is rotated at some
 * pivot unknown to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author bramanarayan
 * @date May 23, 2020
 */
public class SearchMinimumRotated {

	public static void main(String[] args) {
		SearchMinimumRotated solution = new SearchMinimumRotated();
		System.out.println(solution.findMin(new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }));
		System.out.println(solution.findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
		System.out.println(solution.findMin(new int[] { 3, 1 }));
		System.out.println(solution.findMin(new int[] { 1, 2 }));

	}

	public int findMin(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return -1;
		if (n == 1)
			return nums[0];
		int l = 0, h = n - 1, mid= 0;
		if(nums[h] > nums[l])
			return nums[l];
		while (l <= h) {
			mid = l + ((h - l) / 2);
			// If mid+1 is the answer ?
			if (nums[mid] > nums[mid+1]) {
				return nums[mid+1];
				// if mid is the answer ?
			} else if (nums[mid-1]> nums[mid]) {
				return nums[mid];
			} else if (nums[l] < nums[mid]) {
				// left array is sorted, so search right side for minimum
				l = mid + 1;
			} else {
				// right array is sorted. so search left side for minimum
				h = mid - 1;
			}
		}
		return nums[l];
	}

}
