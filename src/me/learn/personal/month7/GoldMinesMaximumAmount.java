/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title 1219 :
 * 
 * Date : Feb 16, 2021
 * 
 * @author bramanarayan
 *
 */
public class GoldMinesMaximumAmount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// PATH WITH MAXIMUM GOLD IN MATRIX

	int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }; // bottom,top,right,left

	public int getMaximumGold(int[][] grid) {
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] != 0) { // explore all gold cells
					max = Math.max(max, dfs(grid, i, j)); // find max out of those
				}
			}
		}
		return max;
	}

	private int dfs(int[][] grid, int i, int j) {
		int curr = grid[i][j]; // save the value of current gold cell
		int max = curr;
		grid[i][j] = 0; // mark as visited, 0 would either mean gold cell is visited or cell does not
						// contain gold
		for (int[] dir : dirs) {
			int x = i + dir[0];
			int y = j + dir[1];
			if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] != 0) { // if within bounds, is
																								// not visited &
																								// contains gold
				max = Math.max(max, curr + dfs(grid, x, y));
			}
		}
		grid[i][j] = curr; // restore back value of current gold cell for further exploration
		return max;
	}

}
