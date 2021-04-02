/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 1275 :
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class FindWinnerOfTicTacToe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int size = 3;

	// move[][] -> indicates from position To destination position
	public String tictactoe(int[][] moves) {

		int m = moves.length;

		char[][] res = new char[3][3];

		for (int i = 0; i < m; i++) {

			// A step has already been taken by someone
			if(res[moves[i][0]][moves[i][1]] == 'X' || res[moves[i][0]][moves[i][1]] == 'O') {
				return "Draw";
			}
			
			// Take a step
			// even step - player A (X)
			if (i % 2 == 0) {
				res[moves[i][0]][moves[i][1]] = 'X';
				if (isWinner(res, moves[i][0], moves[i][1], 'X'))
					return "A";
			}
			// odd step - player B (O)
			if (i % 2 == 1) {
				res[moves[i][0]][moves[i][1]] = 'O';
				if (isWinner(res, moves[i][0], moves[i][1], 'O'))
					return "B";
			}
		}
		return "Pending";
	}

	private boolean isWinner(char[][] res, int row, int col, char player) {
		if (getRowWinner(res, row, player) || getColWinner(res, col, player)
				|| getDiagonalWinner(res, row, col, player)) {
			return true;
		}
		return false;
	}

	private boolean getDiagonalWinner(char[][] res, int row, int col, char player) {
		// we will have two diagonals - left and right
		
		 if (row != col && row+col != res.length-1) return false;
	        boolean topLeftToBottomRight = true;
	        boolean topRightToBottomLeft = true;
	        for (int i=0; i<res.length; i++) {
	            if (res[i][i] != player) topLeftToBottomRight = false;
	        }
	        for (int i=0; i<res.length; i++) {
	            if (res[i][res.length-1-i] != player) topRightToBottomLeft = false;
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
