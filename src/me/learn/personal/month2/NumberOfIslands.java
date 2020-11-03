/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 200 : Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3 
 * 
 * @author bramanarayan
 * @date May 25, 2020
 */
public class NumberOfIslands {

	int[] row = new int[] { -1, 0, 1, 0 };
	int[] col = new int[] { 0, 1, 0, -1 };

	int count = 0;

	public static void main(String[] args) {
		NumberOfIslands solution = new NumberOfIslands();
		int islandCount = solution.numIslands(new char[][] { {'0', '0', '1', '1', '0'},  
            {'1', '0', '1', '1', '0'},  
            {'0', '1', '0', '0', '0'},  
            {'0', '0', '0', '0', '1'}});
		System.out.println("Island Count : " + islandCount);
		
		
		solution.numIslands(new char[][] {});
	}

	public int numIslands(char[][] a) {
		int m = a.length;
		if(m == 0) return 0;
		int n = a[0].length;
		
		
		
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && a[i][j] == '1') {
					count++;
					findArea(a, visited, i, j);
				}
			}
		}
		return count;
	}

	private void findArea(char[][] a, boolean[][] visited, int i, int j) {
		if (isSafe(a, visited, i, j)) {
			visited[i][j] = true;
			for (int k = 0; k < row.length; k++) {
				findArea(a, visited, i + row[k], j + col[k]);
			}
		}
	}

	private boolean isSafe(char[][] a, boolean[][] visited, int i, int j) {
		return i >= 0 && j >= 0 && i < a.length && j < a[0].length && a[i][j] == '1' && !visited[i][j];
	}

}
