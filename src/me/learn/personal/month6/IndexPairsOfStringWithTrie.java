/**
 * 
 */
package me.learn.personal.month6;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 1065 :
 * 
 * Date : Jan 12, 2021
 * 
 * @author bramanarayan
 *
 */
public class IndexPairsOfStringWithTrie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Use trie to build all the words
	// then search the text
	public int[][] indexPairs(String text, String[] words) {
		
		List<int[]> result = new ArrayList<int[]>();
		
		// build Trie
		Trie root = new Trie();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			Trie r = root;
			for (char c : word.toCharArray()) {
				if (r.children[c - 'a'] == null) {
					r.children[c - 'a'] = new Trie();
				}
				r = r.children[c - 'a'];
			}
			r.isWord = true;
		}
		
		
		// use Trie to search word
		for (int i = 0; i < text.length(); i++) {
			Trie curNode = root;
			
			// search if there is any word that exists starting from i to ..
			if (curNode.children[text.charAt(i) - 'a'] != null) {
				int j = i;
				while (j < text.length() && curNode.children[text.charAt(j) - 'a'] != null) {
					curNode = curNode.children[text.charAt(j) - 'a'];
					if (curNode.isWord) {
						result.add(new int[] { i, j });
					}
					j += 1;
				}
			}
		}
		
		return result.toArray(new int[0][]);
	}

	class Trie {
		Trie[] children = new Trie[26];
		boolean isWord = false;
	}
}
