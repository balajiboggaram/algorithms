package me.learn.personal.month2;

/**
 * 
 * Title 27 : Given an array nums and a value val, remove all instances of that
 * value in-place and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * @author bramanarayan
 * @date May 24, 2020
 */
public class RemoveElement {

	public static void main(String args[]) {
		RemoveElement solution = new RemoveElement();
		System.out.println(solution.removeElement(new int[] { 3, 2, 2, 3 }, 3));
		System.out.println(solution.removeElement(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2));

	}

	public int removeElement(int[] nums, int val) {
		int n = nums.length;
		int i = 0, j = 0;
		while (i < n) {
			if (nums[i] != val) {
				nums[j] = nums[i];
				j++;
			}
			i++;
		}
		return j;
	}

}
