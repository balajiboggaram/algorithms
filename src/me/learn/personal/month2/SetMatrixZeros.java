package me.learn.personal.month2;

import java.util.Arrays;

/**
 * 
 * Title 73 : Given a m x n matrix, if an element is 0, set its entire row and
 * column to 0. Do it in-place.
 * 
 * Example 1:
 * 
 * Input: [ [1,1,1], [1,0,1], [1,1,1] ]
 * 
 * Output: [ [1,0,1], [0,0,0], [1,0,1] ]
 * 
 * @author bramanarayan
 * @date May 31, 2020
 */
public class SetMatrixZeros {

	public static void main(String args[]) {
		SetMatrixZeros solution = new SetMatrixZeros();
		// solution.setZeroes(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } });
		// solution.setZeroes(new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5
		// } });
		solution.setZeroes(new int[][] { { 1, 1, 1 }, { 0, 1, 2 } });

	}

	// O(1) space time complexity
	// Deal with (0,0) separately
	public void setZeroes(int[][] a) {

		int m = a.length;
		if (m == 0)
			return;
		int n = a[0].length;

		boolean isFirstRowZero = false, isFirstColZero = false;

		// Mark the matrix
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 0) {
					a[i][0] = 0; // use first column as marker
					a[0][j] = 0; // user first row as marker

					if (i == 0)
						isFirstRowZero = true;
					if (j == 0)
						isFirstColZero = true;
				}
			}
		}

		// fill the inner matrix first.
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a[i][0] == 0 || a[0][j] == 0)
					a[i][j] = 0;
			}
		}

		// deal with first row
		if (isFirstRowZero) {
			for (int i = 0; i < n; i++) {
				a[0][i] = 0;
			}
		}

		// deal with first column
		if (isFirstColZero) {
			for (int i = 0; i < m; i++) {
				a[i][0] = 0;
			}
		}

		System.out.println(Arrays.toString(a));
	}
}
