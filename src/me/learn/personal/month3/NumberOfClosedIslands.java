/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 1254 :
 * 
 * Date : Jan 1, 2021
 * 
 * @author bramanarayan
 *
 */
public class NumberOfClosedIslands {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] row = new int[] { 1, -1, 0, 0 };
	int[] col = new int[] { 0, 0, 1, -1 };

	// a closed island is surrounded with 1's all together.\
	
	// we will basically start with perimeter
	public int closedIsland(int[][] a) {
		int res = 0;
		int m = a.length;
		int n = a[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				// initiate a flood fill for '0' th cell
				if (a[i][j] == 0) {
					
					// add only if this do not touch PERIMETER
					if (dfs(a, i, j))
						res++;
				}
			}
		}

		return res;
	}

	public boolean dfs(int[][] grid, int i, int j) {

		// out of range
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
			// THIS IS THE KEY TO CATCH THE PERIMETER. ONE SHOULD NEVER HIT HERE FOR A CLOSED ISLAND.
			return false;

		// if its 1, all good
		if (grid[i][j] == 1)
			return true;

		grid[i][j] = 1;

		boolean res = true;

		for (int k = 0; k < 4; k++) {
			res = res & dfs(grid, i + row[k], j + col[k]);
		}

		return res;
	}
	
	
	// the other approach is : 
	// eliminate all the islands that touch the perimeter bounadry of matrix. Probably mark with -1 or something
	// Now, again invoke the floodfill search for '0', keep track of count to get # of closed islands.
}
