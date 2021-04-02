/**
 * 
 */
package me.learn.personal.month5;

/**
 * 
 * 1424
 * 
 * @author bramanarayan
 *
 *         Given a list of lists of integers, nums, return all elements of nums
 *         in diagonal order as shown in the below images.
 * 
 *         Input: nums = [[1,2,3],[4,5,6],[7,8,9]] Output: [1,4,2,7,5,3,8,6,9]
 */
public class DiagonalTraversal2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix.length == 0)
			return new int[0];
		int r = 0, c = 0, m = matrix.length, n = matrix[0].length, arr[] = new int[m * n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = matrix[r][c];
			if ((r + c) % 2 == 0) { // moving up
				if (c == n - 1) {
					r++;
				} else if (r == 0) {
					c++;
				} else {
					r--;
					c++;
				}
			} else { // moving down
				if (r == m - 1) {
					c++;
				} else if (c == 0) {
					r++;
				} else {
					r++;
					c--;
				}
			}
		}
		return arr;
	}

}
