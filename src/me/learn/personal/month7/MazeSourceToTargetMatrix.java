/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title 490 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class MazeSourceToTargetMatrix {
	int[][] steps = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		// DFS + cache
		int m = maze.length;
		int n = maze[0].length;
		boolean[][] visited = new boolean[m][n];

		return dfs(maze, start, destination, visited, m, n);
	}

	// current[] -> curRow, curCol
	private boolean dfs(int[][] maze, int[] current, int[] des, boolean[][] visited, int rows, int cols) {

		// if already visited, return false
		if (visited[current[0]][current[1]]) {
			return false;
		}

		// if reached target, viola
		if (current[0] == des[0] && current[1] == des[1]) {
			return true;
		}

		visited[current[0]][current[1]] = true;

		// traverse all the four directions now
		for (int[] step : steps) {

			int i = current[0]; // row
			int j = current[1]; // column
			while (i + step[0] >= 0 && i + step[0] < rows && j + step[1] >= 0 && j + step[1] < cols
					&& maze[i + step[0]][j + step[1]] != 1) {
				i += step[0];
				j += step[1];
			}
			
			if (dfs(maze, new int[] { i, j }, des, visited, rows, cols)) {
				return true;
			}
		}
		return false;
	}

}
