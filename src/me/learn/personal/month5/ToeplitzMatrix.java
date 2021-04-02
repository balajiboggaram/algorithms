/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 766 :
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class ToeplitzMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// A matrix is said to toeplitz only if the every diagnoal from top-left TO
	// bottom-right has same elements

	public boolean isToeplitzMatrix(int[][] a) {

		int m = a.length;
		int n = a[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				// actually we dont need these conditions, you dont care about the last row
				// first cell and first row last cell.
				if (i == m - 1 && j == 0)
					continue;
				if (i == 0 && j == n - 1)
					continue;

				// always check the lower right diagonal element to match, thats it !!
				if (i + 1 < m && j + 1 < n && a[i][j] != a[i + 1][j + 1]) {
					return false;
				}

			}
		}

		return true;
	}

	// you can also solve this via hashmap of i-j, if the value(set) size is more
	// than 1 - then return false, else true.

}
