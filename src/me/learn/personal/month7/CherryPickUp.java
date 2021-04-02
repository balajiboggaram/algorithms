/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title 741 :
 * 
 * Date : Feb 27, 2021
 * 
 * @author bramanarayan
 *
 */
public class CherryPickUp {

	
	//IDEA
	/**
	 * Now, we know that we want collectively maximum cherries.
So, we have to do the traversal of both paths at the same time and select maximum global answer. 
The potential problem of this approach is double counting (if we collect same cherry in 2 paths), but this can be easily avoided in code.
If both are at the same cell we count cherry only once.
Following code is backtracking brute force so it is TLE.
I think Time Complexity is : 4^N*N. As we are calling cherryPickup 4 times recursively with problem size N*N.
	 */
	public int cherryPickup(int[][] grid) {
		return Math.max(0, cherryUtil(grid, grid.length, 0, 0, 0, 0));
	}

	private int cherryUtil(int[][] grid, int n, int r1, int c1, int r2, int c2) {
		
		// since we're only going down and to the right, no need to check for < 0
		// if we went out of the grid or hit a thorn, discourage this path by returning
		// Integer.MIN_VALUE
		if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1)
			return Integer.MIN_VALUE;

		// if person 1 reached the bottom right, return what's in there (could be 1 or  0)
		if (r1 == n - 1 && c1 == n - 1)
			return grid[r1][c1];

		// if person 2 reached the bottom right, return what's in there (could be 1 or 0)
		if (r2 == n - 1 && c2 == n - 1)
			return grid[r2][c2];

		int cherries;
		// if both persons standing on the same cell, don't double count and return what's in this cell (could be 1 or 0)
		if (r1 == r2 && c1 == c2)
			cherries = grid[r1][c1];
		else
			// otherwise, number of cherries collected by both of them equals the sum of
			// what's on their cells
			cherries = grid[r1][c1] + grid[r2][c2];

		// since each person of the 2 person can move only to the bottom or to the
		// right, then the total number of cherries
		// equals the max of the following possibilities:
		// P1 | P2
		// DOWN | DOWN
		// RIGHT | RIGHT
		// DOWN | RIGHT
		// RIGHT | DOWN
		cherries += Math.max(
				Math.max(cherryUtil(grid, n, r1 + 1, c1, r2 + 1, c2), cherryUtil(grid, n, r1 + 1, c1, r2, c2 + 1)),
				Math.max(cherryUtil(grid, n, r1, c1 + 1, r2 + 1, c2), cherryUtil(grid, n, r1, c1 + 1, r2, c2 + 1)));

		return cherries;
	}
	
	// OR
	
	// BEST
	// https://leetcode.com/problems/cherry-pickup/discuss/329945/Very-easy-to-follow-%3A-step-by-step-recursive-backtracking-with-memoization-N4.

}
