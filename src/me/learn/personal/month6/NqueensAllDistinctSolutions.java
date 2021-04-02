/**
 * 
 */
package me.learn.personal.month6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Title 51 :
 * 
 * Date : Jan 30, 2021
 * 
 * @author bramanarayan
 *
 */
public class NqueensAllDistinctSolutions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// main method
	public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				board[i][j] = '.';
		List<List<String>> res = new ArrayList<List<String>>();
		dfs(board, 0, res);
		return res;
	}

	private void dfs(char[][] board, int colIndex, List<List<String>> res) {
		
		// If they ask for count number of solutinos , just keep a count variable and return the count.
		if (colIndex == board.length) {
			res.add(construct(board));
			return;
		}

		for (int i = 0; i < board.length; i++) {
			if (isSafe(board, i, colIndex)) {
				board[i][colIndex] = 'Q';
				dfs(board, colIndex + 1, res);
				board[i][colIndex] = '.';
			}
		}
	}

	private boolean isSafe(char[][] board, int row, int col) {

		// check the row on left side
		// check the upper diagonal on left side
		// check the right diagnoal on left side

		int i, j;

		/* Check this row on left side */
		for (i = 0; i < col; i++)
			if (board[row][i] == 'Q')
				return false;

		/* Check upper diagonal on left side */
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 'Q')
				return false;

		/* Check lower diagonal on left side */
		for (i = row, j = col; j >= 0 && i < board.length; i++, j--)
			if (board[i][j] == 'Q')
				return false;

		return true;
	}

	// helper to append results
	private List<String> construct(char[][] board) {
		List<String> res = new LinkedList<String>();
		for (int i = 0; i < board.length; i++) {
			String s = new String(board[i]);
			res.add(s);
		}
		return res;
	}

}
