package me.learn.personal.month2;

/**
 * 
 * Title 80 : Given a sorted array nums, remove the duplicates in-place such
 * that duplicates appeared at most twice and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * @author bramanarayan
 * @date May 23, 2020
 */
public class RemoveDuplicatesDoubleSorted {

	public static void main(String[] args) {
		RemoveDuplicatesDoubleSorted solution = new RemoveDuplicatesDoubleSorted();
		System.out.println(solution.removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }));
		System.out.println(solution.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 }));

	}

	/**
	 * Just check the element before k in the if condition.
	 */
	public int removeDuplicates(int[] nums) {
		int n = nums.length;

		if (n <= 2)
			return n;
		int i = 2, k = 1;
		while (i < n) {
			if ((nums[k] != nums[i]) || (nums[i] == nums[k] && nums[i] != nums[k - 1])) {
				k++;
				nums[k] = nums[i];
			}
			i++;
		}
		return k + 1;

	}

}
