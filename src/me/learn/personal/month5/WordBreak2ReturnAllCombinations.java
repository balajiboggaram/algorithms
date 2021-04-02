/**
 * 
 */
package me.learn.personal.month5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Title 140 :
 * 
 * Date : Dec 23, 2020
 * 
 * @author bramanarayan
 *
 */
public class WordBreak2ReturnAllCombinations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Set<String> dictionary = new HashSet<String>();

	// Basically map contains the list of words you have already solved. Just try to
	// reuse the result of them again
	Map<String, List<String>> map = new HashMap<>();

	// given a word and dictionary of words, check if you can break the word that
	// has all dictionary words.
	// Now, if you find one such then return all the possible sentences (now add a
	// space inbetween dictionary words)
	public List<String> wordBreak(String s, List<String> wordDict) {

		// add all the words to set
		for (String w : wordDict)
			dictionary.add(w);

		return DFS(s);

	}

	private List<String> DFS(String s) {

		if (map.containsKey(s))
			return map.get(s); // you have already solved this substring s, so return

		// If I have not solved the substring yet
		List<String> result = new LinkedList<String>(); // every time of recursion, you have a new result;, the top
														// recursion would have all the possible results. because you
														// would have solved the entire right part

		// if recursion reaches empty string ?
		if (s.length() == 0) {
			result.add("");
			return result;
		}

		if (dictionary.contains(s)) {
			result.add(s);
		}

		for (int i = 1; i < s.length(); i++) {
			String right = s.substring(i);

			// only if right exists
			if (dictionary.contains(right)) {
				
				// now lets solve the left part
				List<String> leftWords = DFS(s.substring(0, i));
				
				if (leftWords.size() != 0) {
					for (String leftWord : leftWords) {
						result.add(leftWord + " " + right); // this gives left + concatenated with right part
					}
				}
			}
		}

		map.put(s, result);
		return map.get(s);

	}

}
