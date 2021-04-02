package me.learn.personal.month1;

public class WordSearch {

	public static void main(String args[]) {
		char[][] input = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C' , 'S'}, {'A', 'D', 'E', 'E'}};
		WordSearch solution = new WordSearch();
		System.out.println(solution.exist(input, "SEE"));
		System.out.println(solution.exist(input, "ABCCED"));
		System.out.println(solution.exist(input, "ABCB"));

	}

	// Basically checks if a given word exists in boggle or not ?
	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;

		// Try as if you are starting at every letter from the matrix to get the answer
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (isExists(board, i, j, m, n, 0, word)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isExists(char[][] board, int i, int j, int m, int n, int k, String word) {

		if (k == word.length())
			return true; // we found the word already
		boolean exists = false;
		if (isSafe(board, i, j, m, n)) {
			char c = board[i][j]; // fetch the character to match against
			if (word.charAt(k) == board[i][j]) {
				board[i][j] = '#'; // Mark as visited
				exists = isExists(board, i + 1, j, m, n, k + 1, word) || 
						 isExists(board, i - 1, j, m, n, k + 1, word) || 
						 isExists(board, i, j + 1, m, n, k + 1, word) || 
						 isExists(board, i, j - 1, m, n, k + 1, word);
				board[i][j] = c; // revert the marked for visit
			}
		}
		return exists;
	}

	private boolean isSafe(char[][] board, int i, int j, int m, int n) {
		return (i >= 0 && i < m && j >= 0 && j < n);
	}

}
