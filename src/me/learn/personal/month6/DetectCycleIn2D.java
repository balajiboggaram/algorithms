/**
 * 
 */
package me.learn.personal.month6;

/**
 * Title 1559 :
 * 
 * Date : Feb 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class DetectCycleIn2D {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean containsCycle(char[][] grid) {
		boolean[][] seen = new boolean[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (!seen[i][j] && search(grid, grid[i][j], i, j, seen)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean search(char[][] grid, char target, int i, int j, boolean[][] seen) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != target) {
			return false;
		}

		if (seen[i][j]) {
			return true;
		}

		seen[i][j] = true;
		grid[i][j] = '#';

		boolean found = search(grid, target, i + 1, j, seen) || search(grid, target, i - 1, j, seen)
				|| search(grid, target, i, j - 1, seen) || search(grid, target, i, j + 1, seen);

		grid[i][j] = target;

		return found;
	}

}
