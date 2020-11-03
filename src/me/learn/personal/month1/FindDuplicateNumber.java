package me.learn.personal.month1;

/**
 * 
 * Title 287 : Given an array nums containing n + 1 integers where each integer
 * is between 1 and n (inclusive), prove that at least one duplicate number must
 * exist. Assume that there is only one duplicate number, find the duplicate
 * one.
 * 
 * Same as floyd cycle detection algorithm
 * 
 * @author bramanarayan
 * @date May 20, 2020
 */
public class FindDuplicateNumber {

	public static void main(String args[]) {
		FindDuplicateNumber solution = new FindDuplicateNumber();
		System.out.println(solution.findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
	}

	/**
	 * 
	 * We maintain two pointers fast and slow
	 * 
	 * For each step fast will move to the index that is equal to arr[arr[fast]](two
	 * jumps at a time) and slow will move to the index arr[slow](one step at a
	 * time)
	 * 
	 * When fast==slow that means now we are in a cycle.
	 * 
	 * Fast and slow will meet in a circle and the entry point of that circle will
	 * be the duplicate element.
	 * 
	 * Now we need to find entry point so we will start with fast=0 and visit one
	 * step at a time for both fast and slow.
	 * 
	 * When fast==slow that will be entry point.
	 * 
	 * Return the entry point.
	 * 
	 */

	public int findDuplicate(int[] nums) {

		int slow = nums[0];
		int fast = nums[nums[0]];

		while (fast != slow) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}

		// if you reach here - ther eis a cycle or dup element
		// Now lets find the entry point
		fast = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow; // this is culprit duplicate element !!!
	}
}
