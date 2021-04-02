/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 1020 :
 * 
 * Date : Jan 1, 2021
 * 
 * @author bramanarayan
 *
 */
public class NumberOfEnclaves {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		NumberOfEnclaves solution = new NumberOfEnclaves();
		System.out.println(solution.numEnclaves(new int[][] { { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } }));
	}

	int[] row = new int[] { 1, -1, 0, 0 };
	int[] col = new int[] { 0, 0, 1, -1 };

	// this is same problem as count number of closed islands, but with a twist
	// inverse of 0's and 1's. PLUS you need the size of 1's here.

	int res = 0;

	// the other approach is :
	// eliminate all the islands that touch the perimeter bounadry of matrix.
	// Probably mark with -1 or something
	// Now, again invoke the floodfill search for '0', keep track of count to get #
	// of closed islands.
	public int numEnclaves(int[][] a) {
		int m = a.length;
		int n = a[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				// initiate a flood fill for '0' th boundary cell
				if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && a[i][j] == 1) {
					mark(a, i, j, -1); // -1 indicates as INVALID CELL
				}
			}
		}

		// count # of 1's
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (a[i][j] == 1)
					res++;
			}
		}
		return res;
	}

	// mark all the boundary islands to -1
	public void mark(int[][] grid, int i, int j, int value) {

		// out of range
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
			return;

		if (grid[i][j] == 1) {
			grid[i][j] = value; // mark as invalid cell

			for (int k = 0; k < 4; k++) {
				mark(grid, i + row[k], j + col[k], value);
			}
			return;
		}

		if (grid[i][j] == 0)
			return;


	}

}
