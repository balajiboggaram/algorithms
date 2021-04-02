/**
 * 
 */
package me.learn.personal.month7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title 1091 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class ShortestPathInBinaryMatrixRatMaze {

	// PURE BFS based solution
	// try to meet n,n as early as possibleiwth only 0 as paths
	private int dir[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, -1 }, { -1, 1 }, { -1, -1 },
			{ 1, 1 } };

	public int shortestPathBinaryMatrix(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;

		if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
			return -1;
		}

		boolean[][] visited = new boolean[m][n];
		visited[0][0] = true;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });

		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				
				int[] curTemp = queue.remove(); // current cell position
				
				if (curTemp[0] == m - 1 && curTemp[1] == n - 1) {
					return level + 1;
				}
				
				for (int k = 0; k < 8; k++) {
					
					int nextX = dir[k][0] + curTemp[0];
					int nextY = dir[k][1] + curTemp[1];

					if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]
							&& grid[nextX][nextY] == 0) {
						queue.add(new int[] { nextX, nextY });
						visited[nextX][nextY] = true;
					}

				}
			}
			level++;
		}

		return -1;
	}

}
