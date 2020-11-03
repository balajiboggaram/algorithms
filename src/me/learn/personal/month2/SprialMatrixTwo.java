package me.learn.personal.month2;


public class SprialMatrixTwo {

	public static void main(String args[]) {
		SprialMatrixTwo solution = new SprialMatrixTwo();
		System.out.println(solution.generateMatrix(3));
	}

	/**
	 * This one is almost same as spiral matrix -1
	 * 
	 * Ensure - (m-1) and (n-1) cos of integer array/matrix
	 */
	public int[][] generateMatrix(int n) {
		int[][] a = new int[n][n];

		int m = n;
		if (m == 0 || n == 0)
			return a;

		int i, k = 0, l = 0, s = 1;
		/*
		 * k - starting row index m - ending row index l - starting column index n -
		 * ending column index i - iterator
		 */
		while (k < m && l < n) {
			// Print the first row from the remaining rows
			for (i = l; i < n; ++i) {
				a[k][i] = s++;
			}
			k++;

			// Print the last column from the remaining columns
			for (i = k; i < m; ++i) {
				a[i][n - 1] = s++;
			}
			n--;

			// Print the last row from the remaining rows */
			if (k < m) {
				for (i = n - 1; i >= l; --i) {
					a[m - 1][i] = s++;
				}
				m--;
			}

			// Print the first column from the remaining columns */
			if (l < n) {
				for (i = m - 1; i >= k; --i) {
					a[i][l] = s++;
				}
				l++;
			}
		}

		

		return a;
	}

}
