package me.learn.personal.month2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Title 566 : In MATLAB, there is a very useful function called 'reshape',
 * which can reshape a matrix into a new one with different size but keep its
 * original data.
 * 
 * You're given a matrix represented by a two-dimensional array, and two
 * positive integers r and c representing the row number and column number of
 * the wanted reshaped matrix, respectively.
 * 
 * The reshaped matrix need to be filled with all the elements of the original
 * matrix in the same row-traversing order as they were.
 * 
 * If the 'reshape' operation with given parameters is possible and legal,
 * output the new reshaped matrix; Otherwise, output the original matrix.
 * 
 * Example 1:
 * 
 * Input: nums = [[1,2], [3,4]] r = 1, c = 4 Output: [[1,2,3,4]] Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4
 * matrix, fill it row by row by using the previous list.
 * 
 * 
 * @author bramanarayan
 * @date May 29, 2020
 */
public class ReshapeTheMatrix {

	public static void main(String args[]) {
		ReshapeTheMatrix solution = new ReshapeTheMatrix();
		System.out.println(solution.matrixReshape(new int[][] { { 1, 2 }, { 3, 4 } }, 1, 4));
		System.out.println(solution.matrixReshape(new int[][] { { 1, 2 }, { 3, 4 } }, 4, 1));

	}
	
	// No extra memory
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		int m = nums.length;
		if (m < 1)
			return nums;

		int n = nums[0].length;

		int n1 = m * n;
		int n2 = r * c;
		if (n2 != n1)
			return nums;
		int p = 0, q=0;

		int[][] res = new int[r][c];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println(p + "--->" + q);
				System.out.println(nums[i][j]);
				res[p][q] = nums[i][j];
				q++;
				if(q == c) {
					p++;
					q = 0;
				}
			}
		}

		return res;
	}

	public int[][] matrixReshapeMy(int[][] nums, int r, int c) {
		int m = nums.length;
		if (m < 1)
			return nums;

		int n = nums[0].length;

		int n1 = m * n;
		int n2 = r * c;
		if (n2 != n1)
			return nums;
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				q.add(nums[i][j]);
			}
		}

		int[][] res = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				res[i][j] = q.remove();
			}
		}

		return res;
	}
}
