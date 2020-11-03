/**
 * 
 */
package me.learn.personal.month4;

/**
 * Title 1060 :
 * 
 * Given a sorted array A of unique numbers, find the K-th missing number
 * starting from the leftmost number of the array.
 * 
 * Example 1:
 * 
 * Input: A = [4,7,9,10], K = 1 Output: 5 Explanation: The first missing number
 * is 5.
 * 
 * Example 2:
 * 
 * Input: A = [4,7,9,10], K = 3 Output: 8 Explanation: The missing numbers are
 * [5,6,8,...], hence the third missing number is 8.
 * 
 * 
 * @author bramanarayan
 * @date Aug 23, 2020
 */
public class MissingElementSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MissingElementSortedArray solutino = new MissingElementSortedArray();
		System.out.println(solutino.missingElement(new int[] { 4, 7, 9, 10 }, 3));
	}

	public int missingElement(int[] nums, int k) {

		int n = nums.length;

		// if kth missing number is larger than last element of the array
		if (k > missing(n - 1, nums)) {
			return nums[n - 1] + k - missing(n - 1, nums);
		}

		// binary
		int low = 0;
		int high = n - 1;
		while (low != high) {
			int mid = low + (high - low) / 2;
			if (missing(mid, nums) < k) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		// kth missing number is greater than nums[idx - 1]
		// and less than nums[idx]
		return nums[low - 1] + k - missing(low - 1, nums);

	}

	// return how many numbers are missing until nums[i]
	private int missing(int i, int[] nums) {
		return nums[i] - nums[0] - i;

	}
}
