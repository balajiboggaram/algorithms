/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title 30 :
 * 
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * Example 1:
 * 
 * Input: s = "barfoothefoobarman", words = ["foo","bar"] Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar"
 * respectively. The output order does not matter, returning [9,0] is fine too.
 * 
 * Example 2:
 * 
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * 
 * @author bramanarayan
 * @date Jul 20, 2020
 */
public class SubStringConcatenationOfWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SubStringConcatenationOfWords solution = new SubStringConcatenationOfWords();
		System.out.println(solution.findSubstring("barfoothefoobar", new String[] { "foo", "bar" }));
		System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[] { "word","good","best","word" }));
	

	}

	// Map to Map. formed vs required
	public List<Integer> findSubstring(String s, String[] words) {
		
		List<Integer> result = new ArrayList<Integer>();

		if(s == null || s.length() == 0 || words.length == 0) return  result;

		int n = words.length;
		int k = words[0].length() * n;
		int w = words[0].length();

		// basically a frequency map
		Map<String, Integer> requiredMap = new HashMap<String, Integer>();
		for (String word : words) {
			requiredMap.put(word, requiredMap.getOrDefault(word, 0) + 1);
		}

		int required = requiredMap.size();
		for (int i = 0; i <= s.length() - k; i++) {
			int formed = 0;
			Map<String, Integer> formedMap = new HashMap<String, Integer>();
			for (int j = i; j < i+k; j += w) {

				String word = s.substring(j, j + w);
				if (!requiredMap.containsKey(word)) {
					break;
				} else {
					formedMap.put(word, formedMap.getOrDefault(word, 0) + 1);
					if (requiredMap.containsKey(word) && formedMap.get(word) == requiredMap.get(word)) {
						formed++;
					}
					if (formed == required) { // count matches
						result.add(i);
					}
				}
			}
		}
		return result;
	}
}
