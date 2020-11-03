/**
 * 
 */
package me.learn.personal.month2;

import java.util.Arrays;

/**
 * Title 832 :
 * 
 * Given a binary matrix A, we want to flip the image horizontally, then invert
 * it, and return the resulting image.
 * 
 * To flip an image horizontally means that each row of the image is reversed.
 * For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * 
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced
 * by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * 
 * Example 1:
 * 
 * Input: [[1,1,0],[1,0,1],[0,0,0]] Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]]. Then, invert
 * the image: [[1,0,0],[0,1,0],[1,1,1]]
 * 
 * 
 * @author bramanarayan
 * @date Jun 10, 2020
 */
public class FlippingImage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FlippingImage solution = new FlippingImage();
		solution.flipAndInvertImage(new int[][] { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } });
	}

	public int[][] flipAndInvertImage(int[][] a) {
		int m = a.length;
		if (m == 0)
			return a;
		int n = a[0].length - 1;

		// Flip each row
		for (int i = 0; i < m; i++) {
			reverseAndFlip(a, i, n);
			System.out.println(Arrays.toString(a[i]));
		}
		return a;

	}

	private void reverseAndFlip(int[][] a, int i, int h) {
		int l = 0;
		while (l <= h) {
			int temp = a[i][l];
			a[i][l] = (a[i][h] == 1) ? 0 : 1;
			a[i][h] = temp == 1 ? 0 : 1;
			l++;
			h--;
		}
	}

}
