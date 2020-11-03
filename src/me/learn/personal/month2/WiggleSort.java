/**
 * 
 */
package me.learn.personal.month2;

import java.util.Arrays;

/**
 * Title 280 : Given an unsorted array nums, reorder it in-place such that
 * nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * 
 * Example:
 * 
 * Input: nums = [3,5,2,1,6,4] Output: One possible answer is [3,5,1,6,2,4]
 * 
 * 
 * 
 * @author bramanarayan
 * @date May 31, 2020
 */
public class WiggleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WiggleSort solution = new WiggleSort();
		solution.wiggleSort(new int[] { 3, 5, 2, 1, 6, 4 });
		solution.wiggleSort(new int[] { 1,2 });

	}

	// Appears to be simple than the question is :)
	public void wiggleSort(int[] a) {
		int n = a.length;
		if (n == 1)
			return;

		for (int i = 1; i < n ; i += 2) {
			// Check the left violation i.e a > b {remember we need a < b}
			if (a[i - 1] > a[i]) {
				swap(a, i - 1, i);
			}

			// Check the right violation i.e a < b {remember we need a > b}
			if (i < n - 1 && a[i] < a[i + 1]) {
				swap(a, i, i + 1);
			}
		}
		System.out.println(Arrays.toString(a));
	}

	/**
	 * Swap elements in an array at position1 with position2
	 */
	public void swap(int[] a, int pos1, int pos2) {
		int t = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = t;
	}

}
