package me.learn.personal.month1;

/**
 * 
 * Title : Find the first and Last positino of the element in the sorted array.
 * 
 * @author bramanarayan
 * @date May 1, 2020
 */
public class FirstAndLastPosition {

	public static void main(String args[]) {
		FirstAndLastPosition solution = new FirstAndLastPosition();
		solution.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8);
		solution.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6);
		solution.searchRange(new int[] {}, 0);
		solution.searchRange(new int[] { 2, 2 }, 3);
		solution.searchRange(new int[] { 2, 2 }, 2);
		solution.searchRange(new int[] { 1, 1, 2 }, 1);
	}

	public int[] searchRange(int[] nums, int target) {

		int firstIndex = -1;
		int lastIndex = -1;

		if (nums.length < 1)
			return new int[] { firstIndex, lastIndex };
		
		int n = nums.length;
		if (n >= 2) {
			firstIndex = findFirstIndex(nums, 0, n - 1, target);
			lastIndex = findLastIndex(nums, 0, n - 1, target, n);
		}
		System.out.println(firstIndex + "   Indicies   " + lastIndex);
		return new int[] { firstIndex, lastIndex };
	}

	/**
	 * Make sure you track : 
	 * 
	 * if mid is at first element && mid-1 is less than target
	 * => we found answer
	 * 
	 */
	public int findFirstIndex(int[] nums, int low, int high, int target) {

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || target > nums[mid - 1]) && (nums[mid] == target)) {
				return mid;
			} else if (target > nums[mid]) {
				low = mid + 1;
			} else if (target <= nums[mid]) {
				high = mid - 1;
			}
		}
		return -1;
	}

	/**
	 * Make sure you track : 
	 * 
	 * if mid is the last element and mid+1 is greater than mid 
	 * => we found answer
	 */
	public int findLastIndex(int[] nums, int low, int high, int target, int n) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if ((mid == n - 1 || target < nums[mid + 1]) && (nums[mid] == target)) {
				return mid;
			} else if (target >= nums[mid]) {
				low = mid + 1;
			} else if (target < nums[mid]) {
				high = mid - 1;
			}
		}
		return -1;
	}
}
