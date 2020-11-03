package me.learn.personal.month2;

/**
 * 
 * Title 695 : Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]] 
 * 
 * @author bramanarayan
 * @date May 25, 2020
 */
public class MaxAreaIsland {

	// All immediate 8 neighbors (horizontal, vertical and diagonal) 
	/*int[] row = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
	int[] col = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
	*/
	
	// This considers only 4 neigbors (horizontal and vertical)
	int[] row = new int[] { -1, 0, 1, 0  };
	int[] col = new int[] { 0, 1, 0, -1 };
	
	
	int count = 0;
	
	public static void main(String args[]) {
		MaxAreaIsland solution = new MaxAreaIsland();
		int area = solution.maxAreaOfIsland(new int[][] { {0, 0, 1, 1, 0},  
            {1, 0, 1, 1, 0},  
            {0, 1, 0, 0, 0},  
            {0, 0, 0, 0, 1}});
		System.out.println("Area : " + area);
	}

	public int maxAreaOfIsland(int[][] a) {
		int m = a.length;
		int n = a[0].length;
		boolean[][] visited = new boolean[m][n];
		int maxCount = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && a[i][j] == 1) {
					count = 0;
					findArea(a, visited, i, j);
					maxCount = Math.max(maxCount, count);
				}
			}
		}
		return maxCount;
	}

	private void findArea(int[][] a, boolean[][] visited, int i, int j) {
		if (isSafe(a, visited, i, j)) {
			visited[i][j] = true;
			count++;
			for (int k = 0; k < row.length; k++) {
				findArea(a, visited, i + row[k], j + col[k]);
			}
		}
	}

	private boolean isSafe(int[][] a, boolean[][] visited, int i, int j) {
		return i >= 0 && 
				j >= 0 && 
				i < a.length && 
				j < a[0].length && 
				a[i][j] == 1 && 
				!visited[i][j];
	}

}
