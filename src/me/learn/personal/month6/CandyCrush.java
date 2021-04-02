/**
 * 
 */
package me.learn.personal.month6;

/**
 * Title 723 :
 * 
 * Date : Jan 14, 2021
 * 
 * @author bramanarayan
 *
 */
public class CandyCrush {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] candyCrush(int[][] board) {

		int m = board.length, n = board[0].length;

		boolean todo = false;

		// ROW MARK, mark with negative
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j + 2 < n; ++j) {

				int value = Math.abs(board[i][j]);

				// length shold be greater than 2
				if (value != 0 && value == Math.abs(board[i][j + 1]) && value == Math.abs(board[i][j + 2])) { // x == y
																												// == z
					board[i][j] = board[i][j + 1] = board[i][j + 2] = -value;
					todo = true;
				}
			}
		}

		// COLUMN MARK, mark with negative
		for (int i = 0; i + 2 < m; ++i) {
			for (int j = 0; j < n; ++j) {
				int value = Math.abs(board[i][j]);
				if (value != 0 && value == Math.abs(board[i + 1][j]) && value == Math.abs(board[i + 2][j])) {
					board[i][j] = board[i + 1][j] = board[i + 2][j] = -value;
					todo = true;
				}
			}
		}

		// CRUSH step, gravity, write headh and read head
		for (int j = 0; j < n; ++j) {
			
			int wr = m - 1;
			for (int r = m - 1; r >= 0; --r) {
				// write only if its greater than 0. which is not to be crushed
				if (board[r][j] > 0)
					board[wr--][j] = board[r][j]; // write <--- read element
			}
			
			// after the write head, basically fill all 0s
			while (wr >= 0) {
				board[wr--][j] = 0;
			}
		}

		return todo ? candyCrush(board) : board; // if you cannot find any tuple with length >= 3, then we are done.
													// return result
	}
}
