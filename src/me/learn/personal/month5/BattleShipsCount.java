/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 419 :
 * 
 * Date : Dec 31, 2020
 * 
 * @author bramanarayan
 *
 */
public class BattleShipsCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Count the number of battle ships represented as 'X" and '.' normal empty
	// slot.

	// This problem is same as conut of number of isalnds in a given 2D matrix.
	public int countBattleships(char[][] board) {

		int m = board.length;
		int n = board[0].length;

		boolean[][] visited = new boolean[m][n];

		int count = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (board[i][j] == 'X' && !visited[i][j]) {
					count++;
					dfs(board, visited, i, j);
				}

		return count;
	}

	// FLOOD FILL Algorithm
	
	void dfs(char[][] board, boolean[][] vis, int i, int j) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[i].length)
			return;
		if (vis[i][j] || board[i][j] != 'X')
			return;
		vis[i][j] = true;
		dfs(board, vis, i + 1, j);
		dfs(board, vis, i - 1, j);
		dfs(board, vis, i, j + 1);
		dfs(board, vis, i, j - 1);

	}
}
