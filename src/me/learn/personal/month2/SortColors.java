/**
 * 
 */
package me.learn.personal.month2;

import java.util.Arrays;

/**
 * Title 75 : Given an array with n objects colored red, white or blue, sort
 * them in-place so that objects of the same color are adjacent, with the colors
 * in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Example:
 * 
 * Input: [2,0,2,1,1,0] Output: [0,0,1,1,2,2]
 * 
 * @author bramanarayan
 * @date May 31, 2020
 */
public class SortColors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortColors solution = new SortColors();
		solution.sortColors(new int[] { 2, 0, 2, 1, 1, 0 });
		solution.sortColors(new int[] { 0, 1, 2, 0, 1, 2 });
		solution.sortColors(new int[] { 0,1,1,0,1,2,1,2,0,0,0,1 });

	}

	/**
	 * Dutch National Flag Problem
	 */
	public void sortColors(int[] a) {

		int n = a.length;
		int l = 0, m = 0, h = n - 1;

		while (m <= h) {
			if (a[m] == 0) {
				int temp = a[l];
				a[l] = a[m];
				a[m] = temp;
				l++;
				m++;
			} else if (a[m] == 2) {
				int temp = a[h];
				a[h] = a[m];
				a[m] = temp;
				h--;
			} else {
				m++; // if its 1
			}
		}

		System.out.println(Arrays.toString(a));

	}

}
