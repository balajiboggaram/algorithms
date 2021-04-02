/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Title 212 :
 * 
 * Date : Jan 3, 2021
 * 
 * @author bramanarayan
 *
 */
public class WordSearchList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	List<String> result = new ArrayList<String>();
	// explore neighbor cells in around-clock directions: up, right, down, left
	int[] rows = { -1, 0, 1, 0 };
	int[] cols = { 0, 1, 0, -1 };
	Set<String> wordsSet = new HashSet<String>();

	// prepare a trie first.
	// for every given cell in boggle (backtrack - maintain a prefixed string),
	// search if prefixed string exists in the trie
	public List<String> findWords(char[][] board, String[] words) {

		// step 1: prepare a trie for given words list
		TrieNode root = new TrieNode();
		for (String word : words) {
			insert(word, root);
		}

		// step 2 : start the backtracking process
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				char ch = board[i][j]; // starting character of the word.
				if (root.children.containsKey(ch)) {
					searchTrie(board, i, j, root);
				}
			}
		}
		// remove the duplicates to convert to list
		return new ArrayList<String>(result);
	}

	// This is a pure awesome - search matrix and trie parallely
	private void searchTrie(char[][] board, int i, int j, TrieNode root) {

		char letter = board[i][j];
		TrieNode cur = root.children.get(letter); // initally it points to root(word = null or #) kind of node

		if (cur.word != null) {
			// viola, we found the word here
			wordsSet.add(cur.word);
		}

		// Lets start the EXPLORATION
		// we did not find the word yet,

		board[i][j] = '#'; // MARK indicates that this cell is visited.

		for (int k = 0; k < 4; k++) {
			int newRow = i + rows[k];
			int newCol = j + cols[k];

			// out of range - ignore the cells in matrix. lets move on
			if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) {
				continue;
			}

			char neighborCh = board[newRow][newCol];
			if (cur.children.get(neighborCh) != null) {
				searchTrie(board, newRow, newCol, cur);
			}

		}

		board[i][j] = letter; // UNMARK now

	}

	private void insert(String s, TrieNode root) {
		TrieNode cur = root;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (cur.children.get(ch) != null) {
				cur = cur.children.get(ch);
			} else {
				TrieNode chNode = new TrieNode();
				cur.children.put(ch, chNode);
				cur = chNode;
			}
		}
		cur.word = s;// this indicates the isWord = true in your world
	}

	class TrieNode {
		String word = null;
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

		TrieNode() {

		}
	}

}
