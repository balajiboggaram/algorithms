/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title 527 :
 * 
 * Date : Mar 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class WordAbbreviationUsingTrie {

	// Prepare a list of abreviation -> list of words
	// now resolve the conflicts using a Trie
	public List<String> wordsAbbreviation(List<String> dict) {

		Map<String, List<Integer>> map = new HashMap<>();

		// 1) create result set
		List<String> res = new ArrayList<>(Collections.nCopies(dict.size(), null));

		// 2) Group all words with the same shortest abbreviation. For example:
		// "internal", "interval" => grouped by "i6l"
		// "intension", "intrusion" => grouped by "i7n"
		// "god" => grouped by "god"
		// we can notice that only words with the same length and the same start
		// and end letter could be grouped together

		for (int i = 0; i < dict.size(); i++) {

			String word = dict.get(i);

			String abbreviation = getShortestAbbr(word); // get the abbreviation

			map.computeIfAbsent(abbreviation, x -> new ArrayList<Integer>()).add(i); // add the index of word to list of
																						// values
		}

		// 3) Resolve conflicts in each group
		for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {

			String abbreviation = entry.getKey();

			List<Integer> pos = entry.getValue();

			resolve(dict, res, abbreviation, pos);
		}

		return res;
	}

	/**
	 * To resolve conflicts in a group, we could build a trie for all the words in
	 * the group.
	 * 
	 * 
	 * The trie node will contain the count of words that has the same prefix.
	 * 
	 * Then we could use this trie to determine when we could resolve a conflict by
	 * identifying that the count of words in that trie node will only have one word
	 * has the prefix.
	 * 
	 * wordIndexes -> list of collission words for a given abbreviation only.
	 * 
	 */
	private void resolve(List<String> dict, List<String> res, String abbreviation, List<Integer> wordsIndexes) {

		if (wordsIndexes.size() == 1) {
			// there is only one word, so no need of a tries, no collission
			res.set(wordsIndexes.get(0), abbreviation);

		} else {

			Trie root = buildTrie(dict, wordsIndexes);

			for (int index : wordsIndexes) {
				
				String word = dict.get(index);
				
				Trie cur = root;
				int i = 0;
				int n = word.length();
				
				// while loop to find the trie node which only has the 1 word which has
				// the prefix. That means in that position, only current word has that
				// specific character.
				
				// FIND THE TRIENODE WHERE COUNT OF NODE IS 1. that means this will be the unique prefix found.
				while (i < n && cur.next.get(word.charAt(i)).cnt > 1) {
					cur = cur.next.get(word.charAt(i));
					i++;
				}
				
				if (i >= n - 3) {
					res.set(index, word); // set the word itself as is
				} else {
					String pre = word.substring(0, i + 1);
					String newAbbreviation = pre + (n - i - 2) + "" + word.charAt(n - 1);
					res.set(index, newAbbreviation); // index is the original index from the dictionary input
				}
			}
		}
	}

	/**
	 * Get the shortest abbreviation for a word
	 */
	private String getShortestAbbr(String s) {
		if (s.length() <= 3) {
			return s;
		} else {
			return s.charAt(0) + "" + (s.length() - 2) + "" + s.charAt(s.length() - 1);
		}
	}

	/**
	 * Standard way to build the trie, but we record each trie node with the
	 * information of the count of words with the same prefix.
	 */
	private Trie buildTrie(List<String> dict, List<Integer> pos) {
		Trie root = new Trie();
		for (int p : pos) {
			String w = dict.get(p);
			Trie cur = root;
			for (int i = 0; i < w.length(); i++) {
				char c = w.charAt(i);
				if (cur.next.containsKey(c)) {
					cur = cur.next.get(c);
				} else {
					Trie next = new Trie();
					cur.next.put(c, next);
					cur = next;
				}
				cur.cnt++;
			}
		}
		return root;
	}

	/**
	 * TRIE CLASS
	 * 
	 * 
	 */
	private class Trie {
		int cnt = 0;
		Map<Character, Trie> next = new HashMap<>();
	}

}
