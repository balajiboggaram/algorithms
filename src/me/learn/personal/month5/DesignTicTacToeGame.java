/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 348 :
 * 
 * Date : Jan 2, 2021
 * 
 * @author bramanarayan
 *
 */
public class DesignTicTacToeGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DesignTicTacToeGame solution = new DesignTicTacToeGame();
		TicTacToe game = new TicTacToe(3);
		game.move(1, 2, 2);
		game.move(0, 2, 1);

		game.move(0, 0, 2);
		game.move(2, 0, 1);
		game.move(0, 1, 2);
		game.move(1, 1, 1);
	}

}

class TicTacToe {
	int size;
	char[][] res;

	/** Initialize your data structure here. */
	public TicTacToe(int n) {
		res = new char[n][n];
		size = n;
	}

	/**
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row    The row of the board.
	 * @param col    The column of the board.
	 * @param player The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 */

	// THIS IS SIMILAR to FindWinnerOfTicTacToe
	public int move(int row, int col, int player) {

		// take a move/step
		res[row][col] = (char) player;

		if (isWinner(res, row, col, (char) player)) {
			System.out.println(player);
			return player;
		} else {
			System.out.println(player);

			return 0;
		}

	}

	private boolean isWinner(char[][] res, int row, int col, char player) {
		if (getRowWinner(res, row, player) || getColWinner(res, col, player)
				|| getDiagonalWinner(res, row, col, player)) {
			return true;
		}
		return false;
	}

	// good one.
	private boolean getDiagonalWinner(char[][] res, int row, int col, char player) {
		// we will have two diagonals - left and right

		if (row != col && row + col != res.length - 1)
			return false;
		boolean topLeftToBottomRight = true;
		boolean topRightToBottomLeft = true;
		for (int i = 0; i < res.length; i++) {
			if (res[i][i] != player)
				topLeftToBottomRight = false;
		}
		for (int i = 0; i < res.length; i++) {
			if (res[i][res.length - 1 - i] != player)
				topRightToBottomLeft = false;
		}
		return topRightToBottomLeft || topLeftToBottomRight;

	}

	private boolean getColWinner(char[][] res, int col, char player) {
		for (int i = 0; i < size; i++) {
			if (res[i][col] != player)
				return false;
		}
		return true;
	}

	private boolean getRowWinner(char[][] res, int row, char player) {
		for (int i = 0; i < size; i++) {
			if (res[row][i] != player)
				return false;
		}
		return true;
	}
}

// Note that this can be done in O(1) tc
// AMAZING, beautiful

class TicTacToeBEST {
	private int[] rows;
	private int[] cols;
	private int diagonal;
	private int antiDiagonal;

	/** Initialize your data structure here. */
	public TicTacToeBEST(int n) {
		rows = new int[n];
		cols = new int[n];
	}

	/**
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row    The row of the board.
	 * @param col    The column of the board.
	 * @param player The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 */
	public int move(int row, int col, int player) {
		int toAdd = player == 1 ? 1 : -1;

		rows[row] += toAdd;
		cols[col] += toAdd;
		if (row == col) {
			diagonal += toAdd;
		}

		if (col == (cols.length - row - 1)) {
			antiDiagonal += toAdd;
		}

		int size = rows.length;
		
		// if the player 1 wins, you will have (i,j) ith row as 3, jth col as 3 or diagonal as 3 or antidiag as 3.
		// if the player 2 (i. -1) wins, you will have (i.j) ith row as -3, jth col as -3...similarly..
		if (Math.abs(rows[row]) == size || 
			Math.abs(cols[col]) == size || 
			Math.abs(diagonal) == size || 
				Math.abs(antiDiagonal) == size) {
			return player;
		}

		return 0;
	}

}
