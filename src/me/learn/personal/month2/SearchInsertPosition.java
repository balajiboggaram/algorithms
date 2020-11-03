/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 35 : Given a sorted array and a target value, return the index if the
 * target is found. If not, return the index where it would be if it were
 * inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Example 1:
 * 
 * Input: [1,3,5,6], 5 Output: 2
 * 
 * Example 2:
 * 
 * Input: [1,3,5,6], 2 Output: 1
 * 
 * 
 * @author bramanarayan
 * @date Jun 7, 2020
 */
public class SearchInsertPosition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SearchInsertPosition solution = new SearchInsertPosition();
		System.out.println(solution.searchInsert(new int[] { 1, 3, 5, 6 }, 5));
		System.out.println(solution.searchInsert(new int[] { 1, 3, 5, 6 }, 2));
		System.out.println(solution.searchInsert(new int[] { 1, 3, 5, 6 }, 7));
		System.out.println(solution.searchInsert(new int[] { 1, 3, 5, 6 }, 0));
		System.out.println(solution.searchInsert(new int[] { 1, 3 }, 1));
		System.out.println(solution.searchInsert(new int[] { 1, 4, 6, 7, 8, 9 }, 6));

	}

	public int searchInsert(int[] nums, int target) {
		int low = 0;
		int high = nums.length-1;
		int mid = Integer.MIN_VALUE;

		if (target <= nums[0])
			return 0;
		if (target > nums[high])
			return high +1;

		while (low <= high) {
			mid = low + ((high - low) / 2);

			if (target == nums[mid]) {
				return mid;
			} else if (target < nums[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		// Returning low here
		return low;
	}

}
