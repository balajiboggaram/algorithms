package me.learn.personal.month2;

import java.util.Arrays;

/**
 * 
 * Title 189 : Given an array, rotate the array to the right by k steps, where k
 * is non-negative.
 * 
 * Follow up:
 * 
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem. Could you do it in-place with O(1) extra space?
 * 
 * 
 * Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

 * @author bramanarayan
 * @date May 26, 2020
 */
public class RotateArray {

	public static void main(String args[]) {
		RotateArray solution = new RotateArray();
		solution.rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
		solution.rotate(new int[] { 1, 2 }, 3);

	}

	public void rotate(int[] a, int k) {
		int n = a.length;
		if (n < 2 || k == 0 || k == n)
			return;
		if (k > n) {
			k = k % n;
		}
		rotateArray(a, n - k, n - 1);
		rotateArray(a, 0, n - k - 1);
		rotateArray(a, 0, n - 1);
		System.out.println(Arrays.toString(a));
	}

	private void rotateArray(int[] a, int i, int j) {
		if (i < j) {
			while (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
	}

}
