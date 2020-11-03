/**
 * 
 */
package me.learn.personal.month3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Title 819 :
 * 
 * Given a paragraph and a list of banned words, return the most frequent word
 * that is not in the list of banned words. It is guaranteed there is at least
 * one word that isn't banned, and that the answer is unique.
 * 
 * Words in the list of banned words are given in lowercase, and free of
 * punctuation. Words in the paragraph are not case sensitive. The answer is in
 * lowercase.
 * 
 * 
 * Example:
 * 
 * Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"] Output: "ball" Explanation: "hit" occurs 3 times, but it is
 * a banned word. "ball" occurs twice (and no other word does), so it is the
 * most frequent non-banned word in the paragraph. Note that words in the
 * paragraph are not case sensitive, that punctuation is ignored (even if
 * adjacent to words, such as "ball,"), and that "hit" isn't the answer even
 * though it occurs more because it is banned.
 * 
 * 
 * 
 * Note:
 * 
 * 1 <= paragraph.length <= 1000. 0 <= banned.length <= 100. 1 <=
 * banned[i].length <= 10. The answer is unique, and written in lowercase (even
 * if its occurrences in paragraph may have uppercase symbols, and even if it is
 * a proper noun.) paragraph only consists of letters, spaces, or the
 * punctuation symbols !?',;. There are no hyphens or hyphenated words. Words
 * only consist of letters, never apostrophes or other punctuation symbols.
 * 
 * @author bramanarayan
 * @date Jul 10, 2020
 */
public class MostCommonWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MostCommonWord solution = new MostCommonWord();
		System.out.println(solution.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
				new String[] { "hit" }));
	}

	// Note : This uses linear
	// Alternate : we can also use PriorityQueue of Tuple
	public String mostCommonWord(String paragraph, String[] banned) {

		List<String> bannedWords = Arrays.asList(banned);

		Set<Character> puncSet = new HashSet<Character>();
		puncSet.add('!');
		puncSet.add('?');
		puncSet.add(',');
		puncSet.add('\'');
		puncSet.add('.');

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (String s : paragraph.split("\\s+")) {
			// Scrub to remove any punctuation symbols
			if (puncSet.contains(s.charAt(0))) {
				s = s.substring(1); // if leading edge character
			}

			if (puncSet.contains(s.charAt(s.length() - 1))) {
				s = s.substring(0, s.length() - 1); // if trailing edge character
			}
			s = s.toLowerCase();
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		// now see in the map
		String result = null;
		int max = 0;
		for (Entry<String, Integer> e : map.entrySet()) {
			if (!bannedWords.contains(e.getKey()) && e.getValue() > max) {
				result = e.getKey();
				max = e.getValue();
			}
		}
		return result;
	}

}
