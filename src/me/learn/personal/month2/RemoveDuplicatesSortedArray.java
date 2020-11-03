package me.learn.personal.month2;

/**
 * 
 * Title 26 : Given a sorted array nums, remove the duplicates in-place such
 * that each element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * @author bramanarayan
 * @date May 23, 2020
 */
public class RemoveDuplicatesSortedArray {

	public static void main(String args[]) {
		RemoveDuplicatesSortedArray solution = new RemoveDuplicatesSortedArray();
		System.out.println(solution.removeDuplicates(new int[] { 1, 1, 2 }));
		System.out.println(solution.removeDuplicates(new int[] { 0,0,1,1, 1, 2,2,3,4,5 }));

	}

	public int removeDuplicates(int[] nums) {
		int n = nums.length;
		if(n == 1) return 1;
		int i = 1, k = 0;
		while (i < n) {
			if (nums[k] != nums[i]) {
				k++;
				nums[k] = nums[i];
			}
			i++;
		}
		return k + 1;
	}
}
