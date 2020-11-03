package me.learn.personal.month1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Title 54 : Given a matrix of m x n elements (m rows, n columns), return all
 * elements of the matrix in spiral order.
 * 
 * @author bramanarayan
 * @date May 20, 2020
 */
public class SpiralMatrix {

	/**
	 * rows : k to m 
	 * 
	 * colums : l to n 
	 * 
	 * Just follow the circle by traversing from k to m and l to n.
	 */
	public List<Integer> spiralOrder(int[][] a) {

		List<Integer> res = new ArrayList<Integer>();
		int m = a.length;
		if (m == 0)
			return res;

		int n = a[0].length;

		if (m == 0 || n == 0)
			return res;

		int i, k = 0, l = 0;
		/*
		 * k - starting row index m - ending row index l - starting column index n -
		 * ending column index i - iterator
		 */
		while (k < m && l < n) {
			// Print the first row from the remaining rows
			for (i = l; i < n; ++i) {
				res.add(a[k][i]);
			}
			k++;

			// Print the last column from the remaining columns
			for (i = k; i < m; ++i) {
				res.add(a[i][n - 1]);
			}
			n--;

			// Print the last row from the remaining rows */
			if (k < m) {
				for (i = n - 1; i >= l; --i) {
					res.add(a[m - 1][i]);
				}
				m--;
			}

			// Print the first column from the remaining columns */
			if (l < n) {
				for (i = m - 1; i >= k; --i) {
					res.add(a[i][l]);
				}
				l++;
			}
		}

		return res;
	}
}
