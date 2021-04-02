/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Title 648 :
 * 
 * Date : Feb 25, 2021
 * 
 * @author bramanarayan
 *
 */
public class ReplaceWordsSuffixedWithPrefixTrie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String replaceWords(List<String> dict, String sentence) {
		
		Trie trie = new Trie(256); // ascii range
		
		dict.forEach(word -> trie.insert(word));
		
		StringBuilder sb = new StringBuilder();
		
		for(String word : sentence.split("\\s+")) {
			sb.append(trie.getShortestPrefix(word) + " ");
		}
		
		return sb.toString().trim();
		
	}

}

class Trie {

	private int alphabetRange;
	
	private TrieNode root;

	public Trie(int R) {
		this.alphabetRange = R;
		root = new TrieNode();
	}
	
	// Inserts a word into the trie.
	public void insert(String word) {
		insert(root, word);
	}

	// typical insert Trie - recursive
	private void insert(TrieNode root, String word) {
		if (word.isEmpty()) {
			root.isWord = true;
			return;
		}
		if (root.next[word.charAt(0)] == null) {
			root.next[word.charAt(0)] = new TrieNode();			
		}
		
		insert(root.next[word.charAt(0)], word.substring(1));
	}

	// Returns the shortest prefix of the word that is there in the trie
	// If no such prefix exists, return the original word
	public String getShortestPrefix(String word) {
		int len = getShortestPrefix(root, word, -1);
		return (len < 1) ? word : word.substring(0, len);
	}

	private int getShortestPrefix(TrieNode root, String word, int res) {
		if (root == null || word.isEmpty())
			return 0;
		if (root.isWord)
			return res + 1;
		return getShortestPrefix(root.next[word.charAt(0)], word.substring(1), res + 1);
	}

	private class TrieNode {
		private TrieNode[] next = new TrieNode[alphabetRange];
		private boolean isWord;
	}
}
