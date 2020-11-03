package me.learn.personal.month1;

/**
 * 
 * Title : You are given a sorted array consisting of only integers where every
 * element appears exactly twice, except for one element which appears exactly
 * once. Find this single element that appears only once.
 * 
 * Note: Your solution should run in O(log n) time and O(1) space.
 * 
 * @author bramanarayan
 * @date May 12, 2020
 */
public class SingleElementSortedArray {

	public static void main(String args[]) {
		SingleElementSortedArray solution = new SingleElementSortedArray();
		System.out.println(solution.singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));
		System.out.println(solution.singleNonDuplicate(new int[] { 1, 1, 2 }));

	}

	/**
	 * Take concrete examples and work
	 */
	public int singleNonDuplicate(int[] nums) {
		int low = 0;
		int high = nums.length - 1;

		if (nums.length == 1)
			return nums[0];

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
				return nums[mid];
			}
			if (mid % 2 == 0) {
				// mid is even
				if (nums[mid] == nums[mid - 1]) {
					high = mid;
				} else {
					low = mid;
				}
			} else {
				if (nums[mid] == nums[mid - 1]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return nums[low];
	}
}
